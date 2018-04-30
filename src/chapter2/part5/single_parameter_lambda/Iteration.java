package chapter2.part5.single_parameter_lambda;

import java.util.Arrays;
import java.util.List;

public class Iteration {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		friends.forEach(name -> System.out.println(name));
	}
}
