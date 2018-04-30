package chapter2.part7.upper_case;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transform {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> uppercaseNames = new ArrayList<String>();
		
		for (String name : friends) {
			uppercaseNames.add(name.toUpperCase());
		}
		
		for (String name : uppercaseNames) {
			System.out.println(name);
		}
	}
	
}
