package java8.inaction.chapter11.part06;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.junit.Test;

import java8.inaction.chapter11.part05.Discount;
import java8.inaction.chapter11.part05.Quote;
import java8.inaction.chapter11.part05.Shop;

public class PriceCollectSyncNAsyncTest {
	@Test
	public void productPrice() {
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
	 * 동기 작업과 비동기 작업 조합하기
	 */
	private List<String> findPrices(List<Shop> shops, String product) {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		
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
}
