package chapter3.part9.desending;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import chapter3.part9.desending.Person;

public class Compare {
	/*
	 * sorted() 메서드를 호출해서 Comparator 인터페이스를 따르는 람다 표현식을 인수로 넘긴다. 
	 * 람다 표현식의 구현이 이전과 다르게 하면 desending한 결과를 볼 수 있다.
	 */
	public static void printPeople(final String message, final Stream<Person> people) {
		System.out.println(message);
		people.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(
				new Person("Sara", 21),
				new Person("John", 20),
				new Person("Greg", 35),
				new Person("Jane", 21));
		
		printPeople("Sorted in descending order by age: ", 
				people.stream().sorted((person1, person2) -> person2.ageDifference(person1)));
	}

}
