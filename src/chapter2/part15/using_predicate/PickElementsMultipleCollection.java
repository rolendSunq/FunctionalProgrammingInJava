package chapter2.part15.using_predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PickElementsMultipleCollection {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
		final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
		
		// Predicate 타입의 startsWithN 이름의 레퍼런스에 저장한다.
		// 새로운 변수를 사용하면 의도하지 않게 발생하는 중복 코드를 효과적으로 제거할 수 있다.
		final Predicate<String> startsWithN = name -> name.startsWith("N");
		
		// 그러나 여전히 중복 코드의 존재는 남아있다.
		final long countFriendsStartN = friends.stream().filter(startsWithN).count();
		final long countEditorsStartN = editors.stream().filter(startsWithN).count();
		final long countComradesStartN = comrades.stream().filter(startsWithN).count();
		
		System.out.println("Friends Count: " + countFriendsStartN);
		System.out.println("Editors Count: " + countEditorsStartN);
		System.out.println("Comrades Count: " + countComradesStartN);
	}
}
