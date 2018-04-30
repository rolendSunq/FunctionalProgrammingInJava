package chapter2.part9.lambda_map_using;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transform {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> uppercaseNames = new ArrayList<String>();
		friends.stream().map(name -> name.toUpperCase()).forEach(name -> System.out.print(name + " "));
		System.out.println();
	}
}
