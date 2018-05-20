package chapter2.part11.find_element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickElements {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> startWithN = new ArrayList<String>();
		
		for (String name : friends) {
			if (name.startsWith("N")) {
				startWithN.add(name);
			}
		}
		
		System.out.println(startWithN.toString());
	}
}
