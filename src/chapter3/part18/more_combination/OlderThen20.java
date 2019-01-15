package chapter3.part18.more_combination;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import chapter3.value_object.Person;

public class OlderThen20 {
	
	public static void main(String[] args) {
		
		final List<Person> people = Arrays.asList(
				new Person("Sara", 21),
				new Person("John", 20),
				new Person("Greg", 35),
				new Person("Jane", 21));
		
		Comparator<Person> byAge = Comparator.comparing(Person::getAge);
		
		// 첫번째 문자를 기반으로 이름을 그룹핑한다. groupingBy()메서드의 첫 인자에 첫 문자를 리턴하는 람다 표현식을 사용한다.
		// 두번째는 각 그룹에서 가장 나이가 많은 엘리먼트들을 리듀스한다. 가장 나이가 많은 사람을 선택하는 것은 maxBy()메서드를 사용한다.
		Map<Character, Optional<Person>> oldestPersonOfEachLetter = people.stream()
				.collect(Collectors.groupingBy(person -> person.getName().charAt(0),
						Collectors.reducing(BinaryOperator.maxBy(byAge))));
		
		System.out.println("Oldest person of each letter");
		System.out.println(oldestPersonOfEachLetter);
		
	}
	
}
