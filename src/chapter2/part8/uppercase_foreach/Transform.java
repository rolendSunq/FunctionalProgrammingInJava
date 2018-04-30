package chapter2.part8.uppercase_foreach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transform {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> uppercaseNames = new ArrayList<String>();
		friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
		System.out.println(uppercaseNames);
	}
}
