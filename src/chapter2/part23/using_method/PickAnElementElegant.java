package chapter2.part23.using_method;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickAnElementElegant {
	// Optional의 옵션에 대해 값이 존재할 때만 Optional이 코드 블록이나 람다 표현식을 실행한다.
	public static void pickName(final List<String> names, final String startingLetter) {
		final Optional<String> foundName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
		System.out.println(String.format("A name starting with %s: %s", startingLetter, foundName.orElse("No name found")));
	}
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		pickName(friends, "N");
		pickName(friends, "Z");
	}
}
