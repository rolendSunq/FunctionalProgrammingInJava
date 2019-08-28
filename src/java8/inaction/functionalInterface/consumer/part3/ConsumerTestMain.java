package java8.inaction.functionalInterface.consumer.part3;

import java.util.function.Consumer;

public class ConsumerTestMain {

	public static void main(String[] args) {
		int x = 99;
		
		Consumer<Integer> consumer = (a) -> {
			System.out.println("x: " + a);
			System.out.println("y: " + a);
		};
		
		consumer.accept(x);
	}

}
