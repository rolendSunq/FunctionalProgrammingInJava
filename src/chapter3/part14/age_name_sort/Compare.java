package chapter3.part14.age_name_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import chapter3.part14.age_name_sort.Person;

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
		
		// 나이와 이름을 리턴하는 람다 표현식을 각 각 만든다.
		final Function<Person, Integer> byAge = person -> person.getAge();
		final Function<Person, String> byTheirName = person -> person.getName();
		
		// 두개로 각 각 작성된 람다 표현식은 sorted() 메서드에 하나로 묶여서 두개의 속성을 비교한다.
		// comparing() 메소드와 thenCaomparing() 메소드를 통해 나이와 이름의 값을 비교하는 
		// 복합 (composite) comparator를 생성한다.
		printPeople("Sorted in asending order by age and name: ", 
				people.stream()
					.sorted(Comparator.comparing(byAge).thenComparing(byTheirName))
					.collect(Collectors.toList()));
	}
}
