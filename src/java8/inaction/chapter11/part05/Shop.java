package java8.inaction.chapter11.part05;

import java.util.Random;

public class Shop {
	private String shopName;
	
	public Shop(String shopName) {
		this.shopName = shopName;
	}

	public String getShopName() {
		return shopName;
	}

	/*
	 * getPrice 메서드는 ShopName: price:DiscountCode 형식의 문자열을 반환한다.
	 */
	public String getPrice(String product) {
		double price = calculatePrice(product);
		Random random = new Random();
		Discount.Code code = Discount.Code.values()[
			random.nextInt(Discount.Code.values().length)];
		
		return String.format("%s:%.2f:%s", shopName, price, code);
	}
	
	private double calculatePrice(String product) {
		delay();
		Random random = new Random();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}

	public static void delay() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
