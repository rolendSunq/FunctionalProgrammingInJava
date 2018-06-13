package consumer_interface.part04;

import java.util.function.Consumer;

public class ConsumerAcceptTestMain {
	
	public static void main(String[] args) {
		Consumer<String> consumer = x -> {
			printNames(x);
		};
		
		consumer.accept("Jeremy");
		consumer.accept("Paul");
		consumer.accept("Richard");
	}
	
	private static void printNames(String name) {
		System.out.println(name);
	}

}
