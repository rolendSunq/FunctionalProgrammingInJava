package java8.inaction.chapter11.part08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

import org.junit.Test;

public class ThenCombineUsingTest {
	@Test
	public void priceCollect() {
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
				new Shop("LetsSaveBig"),
				new Shop("MyFavoriteShop"),
				new Shop("BuyItAll"));
		long start = System.nanoTime();
		System.out.println(findPriceInUSD(shops, "myPhone27S"));
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + " msecs");
	}
	
	/*
	 * 독립 CompletableFuture 와 비독립 CompletableFuture 합치기
	 * 이전에서 첫 번째 CompletableFuture 에 thenCompose 메서드를 실행한 다음에
	 * 실행 결과를 첫 번째 실행 결과를 입력으로 받는 두 번째 CompletableFuture로 
	 * 전달했다. 
	 * 독립적으로 실행된 두개의 CompletableFuture 결과를 합쳐야 하는 상황이 발생
	 * 하게 되곤한다.
	 * 이때 thenCombine 메서드를 사용한다.
	 *  public <U,V> CompletableFuture<V> thenCombine(
     *      CompletionStage<? extends U> other,
     *      BiFunction<? super T,? super U,? extends V> fn) {
     *          return biApplyStage(null, other, fn);
     *  }
     * 
     * BiFunction 이 두 번째 인수로 사용
     * BiFunction 은 두 개의 CompletableFuture 결과를 어떻게 합칠지 정의한다.
	 */
	public List<String> findPriceInUSD(List<Shop> shops, String product) {
		List<CompletableFuture<Double>> priceFutures = new ArrayList<>();
		
		for (Shop shop : shops) {
			CompletableFuture<Double> futurePriceInUSD = 
					// 제품가격 정보를 요청하는 첫 번째 태스크를 생성한다.
					CompletableFuture.supplyAsync(() -> shop.getPrice(product))
					.thenCombine(
							CompletableFuture.supplyAsync(
									// USD, EUR 의 환율 정보를 요청하는 독립적인 두 번째 태스크를 생성한다.
									() -> ExchangeService.getRate(ExchangeService.Money.EUR, ExchangeService.Money.USD)),
							// 두 결과를 곱해서 가격과 환율 정보를 합친다.
							(price, rate) -> Double.valueOf(price) * rate
					);
			priceFutures.add(futurePriceInUSD);
		}
		
		List<String> prices = priceFutures
				.stream()
				.map(CompletableFuture::join)
				.map(price -> " price is " + price)
				.collect(Collectors.toList());
		
		return prices;
	}
	
	@SuppressWarnings("unused")
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
