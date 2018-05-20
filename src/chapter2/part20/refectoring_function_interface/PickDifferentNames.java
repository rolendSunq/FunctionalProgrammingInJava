package chapter2.part20.refectoring_function_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PickDifferentNames {
	public static void main(String[] args) {
		// 단일 인자 파라메터 람다 표현식은 괄호를 제거 할 수 있다.
		final Function<String, Predicate<String>> startsWithLetter = 
			letter -> name -> name.startsWith(letter);
		
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		final long countFriendStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
		final long countFriendStartS = friends.stream().filter(startsWithLetter.apply("S")).count();
		
		System.out.println("Friends 'N' startWith count: " + countFriendStartN);
		System.out.println("Friends 'S' startWith count: " + countFriendStartS);
		
	}
}
