package chapter5.part06.using_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locking {
	
	// Lock lock 필드 사용. 
	// Locking 클래스의 메서드의 잠금을 공유한다.
	Lock lock = new ReentrantLock(); // or mock
	
	protected void setLock(final Lock mock) {
		lock = mock;
	}
	
	// doOp1 메소드에 여러 테스크들이 잠금되어 있고 다른 테스크들이 남아 있다면
	// 프로그래밍은 어려워 질 수 있고 오류를 발생쉬우며 유지보수도 어렵다.
	// 그러나 단순히 제시한 코드로 이러한 문제점을 찾기는 당연히 어렵다. 책이 제시한 예제와
	// 설명이 이러하다. 끝가지 가보는 수 밖에...
	public void doOp1() {
		lock.lock();
		try {
			// ...critical code
		} finally {
			lock.unlock();
		}
	}
}
