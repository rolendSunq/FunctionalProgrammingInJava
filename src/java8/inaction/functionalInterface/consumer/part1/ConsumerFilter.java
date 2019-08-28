package java8.inaction.functionalInterface.consumer.part1;

import java.util.List;

public class ConsumerFilter {
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for(T i : list) {
			c.accept(i);
		}
	}
}
