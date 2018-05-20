package chapter2.part10.using_method_reference;

import java.util.Arrays;
import java.util.List;

public class Transform {

	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		// map에 파라미터로 제공된 String클래스의 toUpperCase메소드를 사용한다. 이것은 추상 메소드의 구현체로 해당된다.
		// 이전의 예는 람다 표현식으로 추상 메소드이 구현체를 직접 작성했다면 이번은 명시적으로 구현된 클래스의 메소드를 직접
		// 적용하여 사용했다는 것이다. 책에서는 '암묵적인' 표현을 사용했지만 '명시적인' 표현이 더 적당하다고 판단된다.
		friends.stream().map(String::toUpperCase).forEach(name -> System.out.println(name));
	}
}
