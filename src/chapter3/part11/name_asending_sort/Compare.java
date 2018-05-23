package chapter3.part11.name_asending_sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import chapter3.part11.name_asending_sort.Person;

public class Compare {
	 public static void printPeople(final String message, final List<Person> people) {
		 System.out.println(message);
		 people.forEach(System.out::println);
	 }
	 
	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(
				new Person("Sara", 21),
				new Person("John", 20),
				new Person("Greg", 35),
				new Person("Jane", 21));
		
		printPeople("Sorted in ascending order by name: ", 
				people.stream().sorted((person1, person2) -> person1.getName().compareTo(person2.getName()))
				.collect(Collectors.toList()));
	}

}
