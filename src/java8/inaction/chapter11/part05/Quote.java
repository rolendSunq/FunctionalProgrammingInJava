package java8.inaction.chapter11.part05;

import java8.inaction.chapter11.part05.Discount.Code;

public class Quote {
	private final String shopName;
	private final double price;
	private final Discount.Code discountCode;
	
	public Quote(String shopName, double price, Code discountCode) {
		this.shopName = shopName;
		this.price = price;
		this.discountCode = discountCode;
	}
	
	public static Quote parse(String s) {
		String[] split = s.split(":");
		String shopName = split[0];
		double price = Double.parseDouble(split[1]);
		Discount.Code discountCode = Discount.Code.valueOf(split[2]);
		return new Quote(shopName, price, discountCode);
	}

	public final String getShopName() {
		return shopName;
	}

	public final double getPrice() {
		return price;
	}

	public final Discount.Code getDiscountCode() {
		return discountCode;
	}
	
}
