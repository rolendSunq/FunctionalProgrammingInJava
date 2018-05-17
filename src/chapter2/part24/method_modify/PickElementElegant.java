package chapter2.part24.method_modify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickElementElegant {
	// 인스턴스가 없는 경우에 대안되는 값을 제공하기보다 값이 존재할 때만 Optional이 코드 블록이나 람다 표현식을 실행한다.
	public static void pickName(final List<String> names, final String startingLetter) {
		final Optional<String> foundName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
		foundName.ifPresent(name -> System.out.println("Hello " + name));
	}
	
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		pickName(friends, "N");
		pickName(friends, "Z");
	}
}
