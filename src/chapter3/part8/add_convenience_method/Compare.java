package chapter3.part8.add_convenience_method;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import chapter3.part8.add_convenience_method.Person;

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
		/*
		 * sorted() 메서드에 파라미터로 전달한 람다 표현식에서는 두개의 파라미터를 라우팅해야 한다.
		 * 첫 번째 파라미터는 ageDifference() 메서드에 대한 타깃이며 두번째는 그 메서드에 대한 
		 * 인수다. 이코드를 직접 만들어서 사용하기보다는 오피스-스페이스(office-space) 패턴을
		 * 사용할 수 있다(? 이런 패턴도 있나 싶다).
		 * 메서드 레퍼런스를 사용해서 자바 컴파일러가 라우팅되도록 한다.
		 */
		List<Person> ascendingAge = people.stream()
				.sorted(Person::ageDifference)
				.collect(Collectors.toList());
		
		/*
		 * 컴파일러는 비교할 대상인 두 개의 person 인스턴스를 가지며 첫 번째 파라미터는 ageDifference()
		 * 메서드의 타깃을 만들고 두 번째는 그 메서드에 대한 파라미터를 만든다.
		 * 첫 번째 파리미터가 우리가 의도한 메서드 레퍼런스의 타깃이 되도록해야 하머 나머지 파라미터는 그 메서드의 
		 * 인수가 되도록 한다. 이 점을 주의하면 된다.
		 */
		
		printPeople("Sorted in asending order by age: ", ascendingAge);
	}
}
