package chapter3.part7.comparator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Compare {
	
	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(
				new Person("Sara", 21),
				new Person("John", 20),
				new Person("Greg", 35),
				new Person("Jane", 21));
		
		/*
		 * 리스트에서 스트림을 얻어와서 sorted() 메서드를 호출한다.
		 * 이미 갖고 있는 컬렉션을 변경하는 대신 이 메서드는 정렬된 컬렉션을 리턴한다.
		 * 이 메서드를 호출할때 Comparator 파라미터를 설정할 수 있다.
		 */
		List<Person> ascendingAge = people.stream()
				.sorted((person1, person2) -> person1.ageDifference(person2))
				.collect(Collectors.toList());
		
		System.out.println(ascendingAge.toString());
	}

}
