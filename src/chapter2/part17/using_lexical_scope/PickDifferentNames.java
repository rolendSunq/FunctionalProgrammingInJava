package chapter2.part17.using_lexical_scope;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PickDifferentNames {
	// 문자를 추출할 수 있는 filter() 메서드에 함수를 파라미터로 사용하게 한다.
	// 모든 filter() 메서드에 사용하는 함수를 만들수 있으나 filter 메서드의 파라미터에 부합하는
	// 함수를 만들어야 한다. 
	// 단일 파라미터를 받는 함수 이어야 하며, boolean 결과를 리턴하는 함수가 되어야 한다.
	// 비교할 목적으로 문자를 나중에 사용하기 위해 캐시해두는 변수가 필요하며 파라미터로 전달될 때까지
	// 보관한다. name이 해당된다.
	public static Predicate<String> checkIfStartsWith(final String letter) {
		return name -> name.startsWith(letter);
	}
	
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		final long countFriendStartN = friends.stream().filter(checkIfStartsWith("N")).count();
		
		System.out.println("Friends 'N' startWith count: " + countFriendStartN);
	}
	
	// name -> name.startsWith(letter) 에서 letter는 익명함수 범위에 있지 않기 때문에 람다 표현식의
	// 정의에 대해 범위를 정하고 그 범위 안에서 변수 letter를 찾는다. -> 렉시컬 스코프(lexical scope)
}
