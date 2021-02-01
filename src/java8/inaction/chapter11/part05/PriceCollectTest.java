package java8.inaction.chapter11.part05;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.junit.Test;

import java8.inaction.chapter11.part03.Shop;

public class PriceCollectTest {
	/*
	 * CompletableFuture로 비동기 호출 구현하기
	 * List의 CompletableFuture는 각각 계산 결과가 끝난 상점의 이름 문자열을 포함한다.
	 * 하지만 우리가 재구현하는 findPrices 메서드의 반환 형식은 List<String>이므로 모든
	 * CompletableFuture의 동작이 완료되고 결과를 추출한 다음에 List를 반환해야 한다.
	 * 
	 * 두 번째 연산을 List<CompletablFuture<String>>에 적용할 수 있다.
	 * 즉, 리스트의 모든 CompletableFuture에 join을 호출해서 모든 동작이 끝나기를 기다린다.
	 * CompletableFuture클래스의 join 메서드는 Future 인터페이스의 get 메서드와 같은
	 * 의미를 갖는다. 다만 join은 아무 예외도 발생시키지 않는다는 점이 다르다.
	 * 두 번째 map의 람다 표현식을 try/catc로 감쌀 필요가 없다.
	 * 
	 * 두 Map 연산을 하나의 스트림 처리 파이프라인으로 처리하지 않고 두 개의 스트림 파이프라인으로
	 * 처리 했다. 스트림 연산은 게으른 특성이 있으므로 하나의 파이프라인으로 연산을 처리했다면 모든 
	 * 가격 정보 요청 동작이 동기적, 순차적으로 이루어지는 결과가 된다.
	 * CompletableFuture로 각 상점의 정보를 요청할 때 기존 요청 작업이 완료되어야 join이 결과
	 * 를 반환하면서 다음 상점으로 요청할 수 있기 때문이다.
	 */
	@Test
	public void productPriceTest() {
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
				new Shop("LetsSaveBig"),
				new Shop("MyFavoriteShop"),
				new Shop("BuyItAll"));
		long start = System.nanoTime();
		System.out.println(findPrices(shops, "myPhone27S"));
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + " msecs");
	}
	
	private List<String> findPrices(List<Shop> shops, String product) {
		List<CompletableFuture<String>> priceFutures = shops.stream()
				.map(shop -> CompletableFuture.supplyAsync(() -> shop.getShopName() + " Price is " + shop.getPrice(product)))
				.collect(Collectors.toList());
		return priceFutures.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());
	}
}
