package chapter2.part9.lambda_map_using;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Transform {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		@SuppressWarnings("unused")
		final List<String> uppercaseNames = new ArrayList<String>();
		// 스트림의 map메서드는 입력 순서를 출력 순서로 매핑하거나 입력 순서를 다른 순서의 출력으로 변형한다.
		// stream() 메서드는 JDK8의 모든 컬렉션에서 사용할 수 있으며 스트림 인스턴스에 대한 컬렉션을 래핑한다.
		friends.stream().map(name -> name.toUpperCase()).forEach(name -> System.out.print(name + " "));
		System.out.println();
	
		// 다음에 탐구할 메서드 레퍼런스 사용에 대한 예이다.
		List<String> collect = friends.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(collect); // [A, B, C, D]
		System.out.println();
	}
}
