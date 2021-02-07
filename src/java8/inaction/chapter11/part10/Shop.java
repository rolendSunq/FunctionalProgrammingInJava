package java8.inaction.chapter11.part10;

import java.util.Random;

import java8.inaction.chapter11.part05.Discount;

public class Shop {
	private String shopName;
	
	public Shop(String shopName) {
		this.shopName = shopName;
	}

	public String getShopName() {
		return shopName;
	}

	public double getPrice(String product) {
		double price = calculatePrice(product);
		Random random = new Random();
		Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
		return price * (100.0 - Double.valueOf(code.getPercentage())) / 100;
	}
	
	private double calculatePrice(String product) {
		OperateDelay.randomDelay();
		Random random = new Random();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}

}
