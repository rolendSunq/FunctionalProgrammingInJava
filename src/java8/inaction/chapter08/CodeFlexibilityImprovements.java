package java8.inaction.chapter08;

import java.util.function.Supplier;
import java.util.logging.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CodeFlexibilityImprovements {
	private static Logger logger = LoggerFactory.getLogger(CodeFlexibilityImprovements.class);
	/**
	 * 동작 파리미터화 Behaviour Paramenterization
	 * 람다 표현식은 동작 파라미터를 쉽게 구현 가능하며 다양한 람다를 전달하여
	 * 여러 동작을 표현할 수 있다.
	 * 변화하는 요구사항에 대응할 수 있는 코드를 구현할 수 있다.
	 * - 프레디케이트로 다양한 필터링 기능을 구현하거나 비교자로 다양한 비교
	 * 기능을 만들 수 있다.
	 * 
	 * 람다 표현식을 위해 함수형 인터페이스가 필요하다.
	 * 조건부 연기 실행 conditional deferred execution
	 * 실행 어라운드 execute around
	 * 이 두 인터페이스는 자주 사용하는 패턴으로 람다 표현식 리팩토링을 살펴본다.
	 */
	
	public static void main(String[] args) {
		// 조건부 연기 실행
		// 코드 내부에 제어 흐름문이 복잡하게 얽힌 코드
		// 보안 검사, 로깅 관련
		/*
		if (logger.isLoggable(Log.FINER)) {
			logger.finer("Problem: " + generateDianostic());
		}
		*/
		// logger의 상태가 isLoggable 메서드로 클라이언트에게 노출된다.
		// 메세지를 로깅할 때마다 logger 객체의 상태를 매번 확인하는 것은 코드를 복잡하게 한다.
		// logger 객체가 적절한 상태로 설정되었는지 내부적으로 확인하는 log 메서드를 사용해야 한다.
		//logger.log(Level.FINER, "Problem: " + generateDiagnostic());
		// 인수로 전달된 메세지 수준에서 logger가 활성화되어 있지 않더라도 로깅메세지를 평가하게된다.
		// 람다로 특정조건 (logger수준을 FINER로 설정되어 있는 것)에서만 메시지가 생성되도록 생성
		// 과정을 연기(defer)해야한다.
		// Supplier를 인수로 갖는 오버로드된 log메서드를 제공한다.
		// public void log(Level level, Supplier<String> msgSupplier)
		//logger.log(Level.FINER, () -> "Problem: " + generateDiagnostic());
		
	}
	/*
	public void log(Level level, Supplier<String> msgSupplier) {
		if (logger.isLoggable(level)) {
			log(level, msgSupplier);
		}
	}
	*/
	// 객체의 일부 메서드를 호출하는 상황(메세지 로깅)이라면 내부적으로 객체 상태를 확인후 
	// 다음 메서드를 호출(람다, 메서드 레퍼런스를 인수로 사용)하도록 구현한다.
	// 이로서 가독성, 캡슐화가 강화된다.
}
