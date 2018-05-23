package chapter3.part18.grouping;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import chapter3.part18.grouping.Person;

public class OlderThan20 {
	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(
				new Person("Sara", 21),
				new Person("John", 20),
				new Person("Greg", 35),
				new Person("Jane", 21));
		
		Comparator<Person> byAge = Comparator.comparing(Person::getAge);
		Map<Character, Optional<Person>> oldestPersonOfEachLetter = 
				people.stream()
					.collect(Collectors.groupingBy(person -> person.getName().charAt(0), 
							Collectors.reducing(BinaryOperator.maxBy(byAge))));
		
		System.out.println("Oldest person of each letter:");
		System.out.println(oldestPersonOfEachLetter);
	}
}
