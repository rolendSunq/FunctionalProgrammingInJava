package chapter2.part21.select_element;

import java.util.Arrays;
import java.util.List;

public class PickAnElement {
	public static void pickName(final List<String> names, final String startingLetter) {
		// NullPointException 유발
		String foundName = null;
		
		for (String name : names) {
			// 찾고자 하는 엘리먼트가 여러게 중복되어 있다면 어떻게 되는가?
			if (name.startsWith(startingLetter)) {
				foundName = name;
				break;
			}
		}
		
		System.out.println(String.format("A name starting with %s: ", startingLetter));
		
		if (foundName != null) {
			System.out.println(foundName);
		} else {
			System.out.println("No name found");
		}
	}
	
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		pickName(friends, "Neal");
	}
}
