package chapter2.part28.element_join;

import java.util.Arrays;
import java.util.List;

public class PrintList {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		// 결과물 맨 끝에 콤마가 출력된다. 마지막 콤마를 제거하는 방법은 무엇인가?
		for (String name : friends) {
			System.out.println(name + ", ");
		}
		
		System.out.println();
	}
}
