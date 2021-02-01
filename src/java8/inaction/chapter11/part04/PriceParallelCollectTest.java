package java8.inaction.chapter11.part04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import java8.inaction.chapter11.part03.Shop;

public class PriceParallelCollectTest {
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
	 * 병렬 스트림으로 요청 병렬화하기
	 */
	private List<String> findPrices(List<Shop> shops, String product) {
		return shops.parallelStream()
				.map(shop -> String.format("%s price is %.2f", shop.getShopName(), shop.getPrice(product)))
				.collect(Collectors.toList());
	}
}
