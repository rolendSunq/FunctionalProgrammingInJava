package chapter2.part29.for_loop;

import java.util.Arrays;
import java.util.List;

public class PrintList {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		for (int i = 0; i < friends.size() - 1; i++) {
			System.out.println(friends.get(i)+ ", ");
		}
		
		if (friends.size() > 0) {
			System.out.println(friends.get(friends.size() - 1));
		}
	}
}
