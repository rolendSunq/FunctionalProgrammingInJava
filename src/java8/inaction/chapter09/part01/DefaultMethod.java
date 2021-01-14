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
		
	}
}
