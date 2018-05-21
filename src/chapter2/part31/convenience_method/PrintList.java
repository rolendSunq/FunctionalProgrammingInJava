package chapter2.part31.convenience_method;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintList {

	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		System.out.println(friends.stream().map(String::toUpperCase).collect(Collectors.joining(", ")));
	}

}
