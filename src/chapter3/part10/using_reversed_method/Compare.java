package chapter3.part10.using_reversed_method;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import chapter3.part10.using_reversed_method.Person;

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
		
		Comparator<Person> compareAscending = (person1, person2) -> person1.ageDifference(person2);
		
		/*
		 * comparator에서 reversed()를 호출하면 비교 결과가 역순으로 된 다른 Comparator를 얻을 수 있다.
		 * reversed()는 파라미터를 스왑하는 형식으로 비교 순서를 바꾸는 comparator를 생성한다.
		 * reversed() 메서드는 고차 메서드가 되도록 하며 이 함수는 사이드 이팩트 없이 다른 함수형 표현식을 생성하고 리턴할 수 있게 
		 * 해준다.
		 */
		Comparator<Person> compareDescending = compareAscending.reversed();
		
		printPeople("Sorted in ascending order by age: ", people.stream().sorted(compareAscending).collect(Collectors.toList()));
		printPeople("Sorted in descending order by age: ", people.stream().sorted(compareDescending).collect(Collectors.toList()));
	}

}
