package chapter2.part2.for_each;

import java.util.Arrays;
import java.util.List;

public class Iteration {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		// 향상된 for는 내부적으로 Iterator 인터페이스를 사용하며 hasNext()와 next()메서드를 호출한다.
		// part1보다 간결하게 표현한다. 세련되었다고 표헌하는데 개인적인 관점이므로 논의하지 않는다.
		for (String name : friends) {
			System.out.println(name);
		}
	}
}
