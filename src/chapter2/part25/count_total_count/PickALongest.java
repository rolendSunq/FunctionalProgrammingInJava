package chapter2.part25.count_total_count;

import java.util.Arrays;
import java.util.List;

public class PickALongest {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		System.out.println("Total number of charaters in all names: " + friends.stream().mapToInt(name -> name.length()).sum());
	}
}
