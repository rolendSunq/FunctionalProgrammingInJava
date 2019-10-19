package chapter2.part10.count;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transform {
	/**
	 * map() 메서드는 입력 컬렉션을 출력 컬렉션으로 매핑하거나 변경할때 사용한다.
	 * 
	 */
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		@SuppressWarnings("unused")
		final List<String> uppercaseNames = new ArrayList<String>();
		friends.stream().map(name -> name.length()).forEach(count -> System.out.print(count + " "));
		System.out.println();
	}
}
