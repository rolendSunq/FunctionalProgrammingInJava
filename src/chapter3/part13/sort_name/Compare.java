package chapter3.part13.sort_name;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
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
		
		final Function<Person, String> byName = person -> person.getName();
		
		/*
		 * comparing() 메서드는 Comparator를 생성하기 위해 제공된 람다 표현식의 로직을 사용한다.
		 * 고차 함수로 정의되며 고차 함수는 다른 함수를 인자로 받거나 그 결과로 함수를 반환하는 함수다.
		 */
		final List<Person> asendingNames = people.stream().sorted(Comparator.comparing(byName)).collect(Collectors.toList());
		
		printPeople("Sorted by Name: ", asendingNames);
	}
}
