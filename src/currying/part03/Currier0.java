package currying.part03;

import java.util.function.Function;

public class Currier0 {
	public static String concat(String s, Integer i, Integer j) {
		return s + i + j;
	}
	
	public static Function<String, Function<Integer, Function<Integer, String>>> curry() {
		return s -> (i -> (j -> concat(s, i, j)));
	}
	
}
