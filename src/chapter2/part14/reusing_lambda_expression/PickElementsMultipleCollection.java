package chapter2.part14.reusing_lambda_expression;

import java.util.Arrays;
import java.util.List;

public class PickElementsMultipleCollection {
	public static void main(String[] args) {
		/**
		 * 람다 표현식은 코드를 간결하게 만들어 주지만 중복 코드를 발생하기도 한다.
		 * name -> name.startsWith("N")이 사용된 코드를 보면 알수있다.
		 */
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
		final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
		
		final long countFriendsStartN = friends.stream().filter(name -> name.startsWith("N")).count();
		final long countEditorsStartN = editors.stream().filter(name -> name.startsWith("N")).count();
		final long countComradesStartN = comrades.stream().filter(name -> name.startsWith("N")).count();
		
		System.out.println("Friends Count: " + countFriendsStartN);
		System.out.println("Editors Count: " + countEditorsStartN);
		System.out.println("Comrades Count: " + countComradesStartN);
		
		/**
		 * 람다 표현식은 변수에 저장하여 사용할 수 있다. 객체를 만들어 사용하는 것과 같이 이용할 수 있다.
		 * filter() 메서드는 이전 예제에서 람다 표현식으로 처리하는 메소드였고 java.util.function.Predicat 함수형
		 * 인터페이스에 대한 레퍼런스를 받는다.
		 * 여기에서 Predicate 클래스에서 test() 메서드는 우리가 구현해야 할 메서드이며 저장하여 재사용할 수 있는 편의를 
		 * 제공한다.
		 */
	}
}
