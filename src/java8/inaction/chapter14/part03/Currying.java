package java8.inaction.chapter14.part03;

import java.util.function.DoubleUnaryOperator;

public class Currying {
	public static DoubleUnaryOperator curriedConverter(double f, double b) {
		return (double x) -> x * f + b;
	}

	public static DoubleUnaryOperator expandedCurriedConverter(double w, double y, double z) {
		return (double x) -> (x + w) * y + z;
	}
}
