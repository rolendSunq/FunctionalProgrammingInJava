package chapter2.part30.using_join_method;

import java.util.Arrays;
import java.util.List;

public class PrintList {

	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		System.out.println(String.join(", ", friends));
	}

}
