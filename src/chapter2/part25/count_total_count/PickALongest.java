package chapter2.part25.count_total_count;

import java.util.Arrays;
import java.util.List;

/*
 * 컬렉션에서 특정 엘리먼트나 매칭에 대한 엘리먼트를 찾는 과정에서 각각의 엘리먼트에 대해 독립적으로 동작한다.(?)
 * 각각의 엘리먼트에 대해 어떤 오퍼레이션을 사용하여 서로 비교하거나 하나의 값으로 연산하지 않았다.
 * 이번의 예는 엘리먼트간의 비교와 컬렉션에서 하나의 값으로 연산하는 방법에 대해 알아본다.
 */
public class PickALongest {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		// mapToInt() 메서드는 이름을 길이로 변환한다.
		// sum() 메소드를 사용하여 각 엘리먼트의 길이를 총합한다.
		// 최대 길이 max(), 최소 길이 min(), 길이를 정렬하는 sorted(), 길이의 평균을 구하는 average()등을 사용할 수
		// 있으며 메서드를 사용한 후 합계의 결과 길이를 리듀스(reduce)시킨다.
		System.out.println("Total number of charaters in all names: " + friends.stream().mapToInt(name -> name.length()).sum());
	}
}
