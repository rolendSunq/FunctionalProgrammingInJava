package chapter2.part12.using_filter_method;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PickElements {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		// filter method는 람다 표현식으로 boolean 값을 리턴해야 한다. 이 리턴 값이 true라면 결과 컬렉션(startsWithN)에 추가된다.
		final List<String> startsWithN = friends.stream().filter(name -> name.startsWith("N")).collect(Collectors.toList());
		System.out.println(startsWithN.toString());
	}
}
