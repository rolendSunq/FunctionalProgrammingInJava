package java8.inaction.chapter11.part01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/*
 * Integer의 제곱을 계산하는 클래스
 * 1초 지연 후 제곱 계산을 한다.
 */
public class SquareCalculator {
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	
	public Future<Integer> calculate(Integer input) {
		return executor.submit(() -> {
			Thread.sleep(1000);
			return input * input;
		});
	}
}
