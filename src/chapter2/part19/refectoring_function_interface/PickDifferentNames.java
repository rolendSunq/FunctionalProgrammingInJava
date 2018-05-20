package chapter2.part19.refectoring_function_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PickDifferentNames {
	public static void main(String[] args) {
		// 명시적으로 Predicate의 인스턴스를 생성하고 Predicate 인스턴스를 리턴하는 대신 람다 표현식을 리턴한다.
		final Function<String, Predicate<String>> startsWithLetter = 
				(String letter) -> (String name) -> name.startsWith(letter);
		
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		final long countFriendStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
		
		System.out.println("Friends 'N' startWith count: " + countFriendStartN);
	}
}
