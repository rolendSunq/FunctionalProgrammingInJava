package chapter2.part11.map_method_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transform {
	
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		@SuppressWarnings("unused")
		final List<String> uppercaseNames = new ArrayList<String>();
		friends.stream().map(String::toUpperCase).forEach(name -> System.out.println(name));
	}
}
