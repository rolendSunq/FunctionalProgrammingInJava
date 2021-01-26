package java8.inaction.chapter09.part01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DefaultMethod {
	
	/**
	 * 기존 코드 구현을 변경하지 않으면서 인터페이스를 변경하는 방법
	 * 
	 * JAVA8에서 인터페이스를 정의하는 방법
	 * 1. 정적 메서드 static method
	 * 2. 디폴트 메서드  default method
	 * 
	 * 디폴트 메서드는 인터페이스의 구현 클래스에서 자동으로 상속 받는다.
	 * default 키워드를 사용한다.
	 * defulat void sort(Comparator<? super E> c) {
	 *     Collections.sort(this, c);
	 * }
	 * 
	 */
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 6);
		System.out.println("Before numbers--->>> " + numbers);
		// sort는 List 인터페이스의 디폴트 메서드다.
		// naturalOrder 표준 알파벳 순서(자연 순서)로 정렬하며 Comparator객체를 반환하는 
		// Comparator 인터페이스에 추가된 정적 메서드다.
		numbers.sort(Comparator.naturalOrder());
		System.out.println("After numbers--->>> " + numbers); 
		
		/**
		 * Collection의 stream 메서드 정의 코드
		 * default Stream<E> stream() {
		 *     return StreamSupport.steam(spliterator(), false);
		 * }
		 * 스트림 메서드는 내부적으로 StreamSupport.stream 메서드를 호출하여 스트림을 반환한다.
		 * steam 메서드의 내부에서는 Collection 인터페이스의 다른 디폴트 메서드 spliterator도 호출한다.
		 * 디폴트 메서드의 장점은 자바 API의 호환성을 유지하면서 변경할 수 있다는 것이다.
		 * 디폴트 메서드가 도입되기 전에 상황은 새로운 기능이 추가되면 기존의 클래스를 변경해야 했다.
		 * 또한 그 클래스의 사용 범위가 크다면 단순한 문제는 아닐 것 이다.
		 * 그래서 디폴트 메서드를 이용하면 인터페이스의 기본 구현을 그대로 상속되며 자유롭게 새로운 메서드를 
		 * 추가할 수 있게 된다. 
		 */
	}
}
