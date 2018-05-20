package chapter2.part26.reduce_pattern;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickALongest {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final Optional<String> aLongName = 
			friends.stream().reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
		aLongName.ifPresent(name -> System.out.println(String.format("A longest name: %s", name)));
	}
}
