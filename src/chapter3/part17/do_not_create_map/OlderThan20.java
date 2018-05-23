package chapter3.part17.do_not_create_map;

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
		 * groupingBy() 메서드는 다중 영역을 조합화여 묶을 수 있다.
		 * 간단한 groupingBy 컬렉터(collector)는 분류자(classifier)를 사용해서 엘리먼트의
		 * 스트림을 만든다.
		 * 일반적인 groupingBy 컬렉터는 다른 컬렉터를 각 버킷(bucket)에 적용할 수 있다.
		 */
		Map<Integer, List<String>> nameOfPeopleByAge = people.stream()
				.collect(
						Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
		
		/*
		 * groupingBy()는 두 개의 파라미터를 가진다. 그러나 내부적으로 3개의 파라미터를 가진 groupingBy()메소드로 연결된다. 
		 * 첫 번째는 그룹을 만드는 기준이 되는 나이이고, 두 번째는 mapping() 함수 호출의 결과인 Collector이다.
		 * 이 매소드는 Collector Utility class에  있고 static이다.
		 * 따라서 당연하겠지만 mapping() 메소드를 사용하려면 Collectors.mapping()으로 사용한다.
		 * mapping() 메소드는 두 개의 파라미터를 가지며 map(이 경우 이름)의 속성이며 다른 하나는
		 * 속성에 대한 결과를 담는 컬렉션이다.
		 */
		
		System.out.println("People grouped by age: " + nameOfPeopleByAge);
		
		
	}

}
