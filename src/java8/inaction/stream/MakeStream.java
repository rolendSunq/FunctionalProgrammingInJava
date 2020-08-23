package java8.inaction.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class MakeStream {
	public static void main(String[] args) {
		/*
		 * 임의의 수를 인수로 받는 정적 메소드 Stream.of를 이용하여 스트림을 만들수 있다.
		 */
		Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);
		
		int[] numbers = {2, 3, 5, 7, 11, 13};
		int sum = Arrays.stream(numbers).sum();
		System.out.println("배열 numbers의 총 합계: " + sum);
	}
}
