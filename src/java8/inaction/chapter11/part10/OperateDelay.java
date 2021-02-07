package java8.inaction.chapter11.part10;

import java.util.Random;

public class OperateDelay {
	private static final Random random = new Random();
	public static void randomDelay() {
		int delay = 500 + random.nextInt(2000);
		
		try {
			Thread.sleep(delay);
		} catch(InterruptedException ie) {
			throw new RuntimeException(ie);
		}
	}
}
