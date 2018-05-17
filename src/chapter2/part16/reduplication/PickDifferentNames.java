package chapter2.part16.reduplication;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PickDifferentNames {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		final Predicate<String> startsWithN = name -> name.startsWith("N");
		final Predicate<String> startsWithB = name -> name.startsWith("B");
		
		final long countFriendsStartN = friends.stream().filter(startsWithN).count();
		final long countFriendsStartB = friends.stream().filter(startsWithB).count();
		
		System.out.println("Friends startWith 'N' count: " + countFriendsStartN);
		System.out.println("Friends startWith 'B' count: " + countFriendsStartB);
	}
}
