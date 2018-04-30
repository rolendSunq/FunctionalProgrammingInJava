package chapter2.part4.lambda;

import java.util.Arrays;
import java.util.List;

public class Iteration {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		friends.forEach((final String name) -> System.out.println(name));
	}
}
