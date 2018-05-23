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
		
		Map<Integer, List<String>> nameOfPeopleByAge = people.stream()
				.collect(
						Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
		
		System.out.println("People grouped by age: " + nameOfPeopleByAge);
	}

}
