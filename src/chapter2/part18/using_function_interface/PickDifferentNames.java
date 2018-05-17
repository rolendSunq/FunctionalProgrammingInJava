package chapter2.part18.using_function_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PickDifferentNames {
	
	public static void main(String[] args) {
		// 정적 메서드 checkIfStartsWith 메서드를 리팩토링 했다. startsWithLetter 변수는
		// 스트링을 인수로 갖는 Function을 참조하며 Predicate를 리턴한다.
		final Function<String, Predicate<String>> startsWithLetter = (String letter) -> {
			Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
			return checkStarts;
		};
		
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		final long countFriendStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
		
		System.out.println("Friends 'N' startWith count: " + countFriendStartN);
	}
}
