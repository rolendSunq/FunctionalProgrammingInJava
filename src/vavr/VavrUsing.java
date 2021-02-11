package vavr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.vavr.control.Option;

public class VavrUsing {
	/*
	 * Option 의 주요 목표는 코드에서 null 검사를 제거하는데 있다.
	 * Optional과 유사하며 Vavr의 객체 컨테이너이다.
	 * Vavr 의 Option은 Serializable Iterable을 구현하고 더 풍부한 API 를 가지고 있다.
	 * 
	 * 모든 객체 (대부분 참조 주소를 가지고 있다)는 null 값을 가질 수 있고 
	 * 일반적으로 if문으로 null여부를 확인 해야한다. 이 과정으로 코드를 강력하고 안정적으로 만든다.
	 * 
	 */
	@Test
	public void givenValue_whenNullCheckNeeded_thenCorrect() {
		Object possibleNullObj = null;
		
		if (possibleNullObj == null) {
			possibleNullObj = "someDefaultValue";
		}
		
		assertNotNull(possibleNullObj);
	}
	
	// 확인하지 않으면 간단한 NPE로 인해 중단 될 수 있다.
	@Test(expected = NullPointerException.class)
	public void givenValue_whenNullCheckNeeded_thenCorrect2() {
		Object possibleNullObj = null;
		assertEquals("somevalue", possibleNullObj.toString());
	}
	
	/*
	 * null 검사는 특히 if 문이 여러개 중첩되는 경우 코드를 장황하게 만들며
	 * 읽기 어럽게 만든다.
	 * Option은 null 을 완전히 제거하고 가능한 각 상황에 대해 유효한 개체 참조로 
	 * 대체 하여 문제를 해결한다.
	 */
	@Test
	public void givenValue_whenCreatesOption_thenCorrect() {
		Option<Object> noneOption = Option.of(null);
		Option<Object> someOption = Option.of("val");
		
		assertEquals("None", noneOption.toString());
		assertEquals("Some(val)", someOption.toString());
	}
}
