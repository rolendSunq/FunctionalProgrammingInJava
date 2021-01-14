package java8.inaction.chapter08.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ProductFactory {
	public static Product createProduct(String name) {
		switch (name) {
		case "loan":
			return new Loan();
		case "stock":
			return new Stock();
		case "bond":
			return new Bond();
		default:
			throw new RuntimeException("No such product " + name);	
		}
	}
	
	public static Product createProductLambda(String name) {
		final Map<String, Supplier<Product>> map = new HashMap<>();
		Supplier<Product> p = map.get(name);
		if (p != null) return p.get();
		throw new IllegalArgumentException("No such product " + name);
	}
}
