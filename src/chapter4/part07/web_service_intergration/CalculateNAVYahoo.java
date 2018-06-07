package chapter4.part07.web_service_intergration;

import chapter4.CalculateNAV;
import chapter4.YahooFinance;

public class CalculateNAVYahoo {
	public static void main(String[] args) {
		final CalculateNAV calculateNav = new CalculateNAV(YahooFinance::getPrice);
		System.out.println(String.format("100 shares of Google worth: $%.2f", calculateNav.computeStockWorth("GOOG", 100)));
	}
}
