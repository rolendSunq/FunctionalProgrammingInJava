package chapter2.part22.reusing_lambda_expression;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickAnElement {
	// Optional 클래스는 결과가 없을 경우 NullPointerException을 막아주며 결과가 없다는 메세지를 출력 가능하게 해준다.
	// isPresent() 메서드를 이용하여 객체의 존재 여부를 확인 할 수 있으며 get() 메서드를 사용하여 현재 값을 가져온다.
	// 결과에서 놓친 인스턴스에 대해 대신할 값을 설정 할 수 있으며 orElse() 메서드를 사용할 수 있다.
	public static void pickName(final List<String> names, final String startingLetter) {
		final Optional<String> foundName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
		System.out.println(String.format("A name starting with %s: %s", startingLetter, foundName.orElse("No name found")));
	}
	
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		pickName(friends, "Raju");
	}
}
