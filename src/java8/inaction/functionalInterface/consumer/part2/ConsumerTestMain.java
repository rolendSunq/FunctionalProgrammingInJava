package java8.inaction.functionalInterface.consumer.part2;

import java.util.function.Consumer;

public class ConsumerTestMain {

	public static void main(String[] args) {
		Consumer<String> consumer = (x) -> System.out.println(x.toLowerCase());
		consumer.accept("JAVA Consumer Function Interface");
	}

}
