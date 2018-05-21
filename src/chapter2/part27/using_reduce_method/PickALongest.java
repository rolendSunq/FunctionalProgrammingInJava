package chapter2.part27.using_reduce_method;

import java.util.Arrays;
import java.util.List;

public class PickALongest {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		// 기본값이나 기준값을 설정하고 싶으면 reduce() 메소드의 오버로드된 메서드에 추가 파라미터로 원하는 값을 넘기면 된다.
		// 주어진 기준보다 긴 이름이 있다면, 그 이름이 선택된다. 그렇지 않으면 함수는 기준값을 리턴한다.
		// 만약 컬렉션이 비여있다면 기준값을 리턴하며 값이 없거나 존재하지 않는 다는 제어문을 추가할 필요가 없다.
		final String steveOrLonger =  friends.stream().reduce("Steve", (name1, name2) ->
			name1.length() >= name2.length() ? name1 : name2);
		
		System.out.println(String.format("A longest name: %s", steveOrLonger));
	}
}
