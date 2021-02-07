package java8.inaction.chapter11.part10;

import java8.inaction.chapter11.part10.Quote;

public class Discount {
	public enum Code {
		NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);
		
		private final int percentage;
		
		Code(int percentage) {
			this.percentage = percentage;
		}
		
		public int getPercentage() {
			return percentage;
		}
	}
	
	public static String applyDiscount(Quote quote) {
		return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
	}
	
	private static double apply(double price, Code code) {
		OperateDelay.randomDelay();
		return format(price * (100 - code.getPercentage()) / 100);
	}
	
	private static double format(double d) {
		return Double.valueOf(d);
	}

}
