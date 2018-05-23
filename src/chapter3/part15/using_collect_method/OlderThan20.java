package chapter3.part15.using_collect_method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chapter3.part15.Person;

public class OlderThan20 {
	
	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(
				new Person("Sara", 21),
				new Person("John", 20),
				new Person("Greg", 35),
				new Person("Jane", 21));
		
		List<Person> olderThan20 = people.stream()
				.filter(person -> person.getAge() > 20)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		
		System.out.println("People older than 20: " + olderThan20);
	}
	
}
