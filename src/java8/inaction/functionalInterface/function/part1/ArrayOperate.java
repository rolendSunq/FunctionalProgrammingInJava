package java8.inaction.functionalInterface.function.part1;

import java.util.ArrayList;
import java.util.List;

public class ArrayOperate {
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for (T s : list) {
			result.add(f.apply(s));
		}
		return result;
	 }
}
