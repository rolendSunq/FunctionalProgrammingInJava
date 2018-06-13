package consumer_interface.part02;

import java.util.function.Consumer;

public class BlockStatementTestMain {
	
	public static void main(String[] args) {
		int x = 99;
		Consumer<Integer> myConsumer = y -> {
			System.out.println("x: " + x);
			System.out.println("y: " + y);
		};
		myConsumer.accept(x);
	}

}
