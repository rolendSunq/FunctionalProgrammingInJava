package java8.inaction.chapter11.part07;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

import org.junit.Test;

import java8.inaction.chapter11.part05.Discount;
import java8.inaction.chapter11.part05.Quote;
import java8.inaction.chapter11.part05.Shop;

public class PriceCollectCustomExecutorTest {
	@Test
	public void priceCollect() {
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
				new Shop("LetsSaveBig"),
				new Shop("MyFavoriteShop"),
				new Shop("BuyItAll"));
		long start = System.nanoTime();
		System.out.println(findPrices(shops, "myPhone27S"));
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + " msecs");
	}
	
	/*
	 * CompletableFuture에 thenApply 메서드를 호출한 다음 문자열을  Quote 인스턴스로 
	 * 변환하는 Function으로 전달한다.
	 * thenApply메서드는 CompletableFuture가 끝날 때까지 블록하지 않는다는 점을 주의해야한다.
	 * CompletableFuture가 동작을 완료한 다음 thenApply 메서드로 전달된 람다 표현식을 사용할 수 있다.
	 * CompletableFuture<String>을 CompletableFuture<Quote>로 변환하게 된다.
	 * CompletableFuture의 결과물로 무엇을 할지 지정하는 것과 같다.
	 * 
	 * CompletableFuture를 조합해서 할인된 가격 계산하기
	 * 세 번째 map연산에서 상점에서 받은 할인전 가격에 원격 Discount 서비스에서 제공하는 할인율을 적용해야 한다.
	 * 원격 실행이 포함된다고 가정하고(1초 지연 원격 실행 흉내) 동기적으로 작업을 수행한다.
	 * 결국 두 개의 비동기 동작을 만들 수 있는데 상점에서 얻은 가격 정보를 Quote로 변환,
	 * 변환된 Quote를 Discount 서비스로 전달해서 할인된 최종가격 획득하기
	 * 
	 * CompletableFuture API는 두 비동기 연산을 파이프 라인으로 만들 수 있도록  thenCompose 메서드를 제공한다.
	 * thenCompose 메서드는 첫 번째 연산의 결과를 두 번째 연산으로 전달한다.
	 */
	private List<String> findPrices(List<Shop> shops, String product) {
		ExecutorService executor = getExecutor(shops);
		
		List<CompletableFuture<String>> priceFutures = shops.stream()
				// 각 상점에서 할인전 가격을 비동기적으로 얻는다.
				.map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
				// 상점에서 반환한 문자열을 Quote 객체로 변환한다.
				.map(future -> future.thenApply(Quote::parse))
				// 결과 Future를 다른 비동기 작업과 조합해서 할인 코드를 적용한다.
				.map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
				.collect(Collectors.toList());
		
		return priceFutures.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());
	}
	
	/*
	 * custom Executor 사용하기
	 * 실제로 필요한 작업량을 고려하여 풀을 관리하고 스레드 수에 맞게 Executor를 만들면 좋을 것이다.
	 * 풀에서 관리하는 스레드의 수를 어떻게 결정할까?
	 * 스레드 풀이 너무 크면 CPU와 메모리 자원을 서로 경쟁하느라 시간을 낭비할 수 있다.
	 * 반면 스레드 풀이 너무 작으면 CPU의 일부 코어는 활용되지 않을 수 있다.
	 * 
	 * N(threads) = N(cpu) * U(cpu) * (1 + W/C)
	 * N(cpu) : Runtime.getRuntime().availableProcessors()가 반환하는 코어수
	 * U(cpu) : 0과 1사이의 값을 갖는 CPU 활용 비율
	 * W/C는 대기시간과 계산시간의 비율
	 * 
	 * 대상 CPU 활용률이 100%라면 400스레드를 갖는 풀을 만들어야 하지만 상점 수보다 많은 스레드를 
	 * 갖는 것은 낭비이다. 따라서 한 상점에 하나의 스레드가 할당 될 수 있도록 한다.
	 * 스레드 수가 너무 많으면 오히려 서버가 크래시될 수 있으므로 하나의 Executor에서 사용할 스레드의
	 * 최대 개수는 100 이하로 설정하는 것이 바람직하다.
	 * 
	 * 풀은 데몬 스레드(daemon thread)를 포함한다.
	 * 자바에서 일반 스레드가 실행 중이면 자바 프로그램은 종료되지 않는다.
	 * 따라서 어떤 이벤트를 한없이 기다리면서 종료되지 않는 일반 스레드가 있으면 문제가 될 수 있다.
	 * 하지만 데몬 스레드는 자바 프로그램이 종료될 때 강제로 실행이 종료될 수 있다.
	 */
	private ExecutorService getExecutor(List<Shop> shops) {
		final ExecutorService executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setDaemon(true);
				return t;
			}
			
		});
		
		return executor;
	}
}
