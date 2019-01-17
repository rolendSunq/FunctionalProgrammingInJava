 package chapter5.part07.expression_lambda_lock;

import java.util.concurrent.locks.Lock;

/**
 * 람다 표현식을 사용하여 잠금을 관리하는 클래스
 */
public class Locker {
	
	// Lock 클래스에서 동작하는 번거로운 작업들을 모두 처리한다.
	// 이 메소드를 사용하여 위험 부분을 래핑할 수 있다.
	public static void runLocked(Lock lock, Runnable block) {
		lock.lock();
		
		try {
			block.run();
		} finally {
			lock.unlock();
		}
	}
}
