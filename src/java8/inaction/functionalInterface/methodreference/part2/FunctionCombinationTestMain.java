package java8.inaction.functionalInterface.methodreference.part2;

import java.util.function.Function;

public class FunctionCombinationTestMain {

	public static void main(String[] args) {
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> h = f.andThen(g);
		int result = h.apply(1);
	}

}
