package chapter3.part16.grouping_by;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import chapter3.part16.grouping_by.Person;

public class OlderThan20 {

	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(
				new Person("Sara", 21),
				new Person("John", 20),
				new Person("Greg", 35),
				new Person("Jane", 21));
		/*
		 * collect() 메서드에 대한 간단한 호출로 그룹을 만드는 것이 가능하다.
		 * groupingBy() 메서드는 람다 표현식이나 메서드 레퍼런스를 갖는다.
		 * groupingBy()에서 파라미터로 사용하는 람다 표현식이나 메서드 레퍼런스를
		 * 분류 함수(classifier function)이라고 한다.
		 */
		Map<Integer, List<Person>> peopleByAge = people.stream()
				.collect(Collectors.groupingBy(Person::getAge));
		
		System.out.println("Grouped by age: " + peopleByAge);
	}

}
