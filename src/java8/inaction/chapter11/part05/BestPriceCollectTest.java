package java8.inaction.chapter11.part05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import java8.inaction.chapter11.part05.Shop;

public class BestPriceCollectTest {
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
		return shops.stream()
				// 각 상점에서 할인전 가격 얻기
				.map(shop -> shop.getPrice(product))
				// 상점에서 반환한 문자열을 Quote 객체로 변환한다.
				.map(Quote::parse)
				// Discount 서비스를 이용해서 각 Quote에 할인을 적용한다.
				.map(Discount::applyDiscount)
				.collect(Collectors.toList());
	}
}
