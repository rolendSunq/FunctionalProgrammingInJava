package chapter2.part3.using_java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Iteration {
	/**
	 * 함수형 스타일로 변경하는 이유
	 * 1. for루프는 본질적으로 순차적인 방식이라 병렬화하기 어렵다.
	 * 2. for루프는 비다형적(non-polymorphic)으로 설정에 의해 원하는 목적을 수행한다.
	 * for문에 컬렉션을 넘겨서 테스크를 수행한다. 이는 다형성(polymorphic)을 고려한 것이다.
	 * 3. for루프는 특정 이터레이션을 구현하기 때문에 설계단위의 목적에 맞지 않다.
	 * 
	 */
	
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		// forEach 내부에 익명함수를 인자로 사용하였다.
		friends.forEach(new Consumer<String>() {
			public void accept(final String name) {
				System.out.println(name);
			}
		});
	}
}
