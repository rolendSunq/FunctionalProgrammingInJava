package chapter2.part1.iteration;

import java.util.Arrays;
import java.util.List;

public class Iteration {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		for (int i = 0; i < friends.size(); i++) {
			System.out.println(friends.get(i));
		}
	}
}
