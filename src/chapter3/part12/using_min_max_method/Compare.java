package chapter3.part12.using_min_max_method;

import java.util.Arrays;
import java.util.List;

import chapter3.part11.name_asending_sort.Person;

public class Compare {
	
	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(
				new Person("Sara", 21),
				new Person("John", 20),
				new Person("Greg", 35),
				new Person("Jane", 21));
		
		/*
		 * min() 메서드 호출에서 ageDifference()에 대한 래퍼런스를 사용한다. 
		 * min() 메서드는 Optional을 리턴하며 리스트가 비어 있을 경우나 
		 * 찾고자 하는 가장 젊은 사람을 찾을 수 없을 수도 있기 때문이다.
		 * ifPresent() 메서드를 사용해서 Optional로 부터 액세스할 수 있는 가장 
		 * 젊은 사람의 정보를 나타낸다.
		 */
		people.stream()
			.min(Person::ageDifference)
			.ifPresent(youngest -> System.out.println("Youngest: " + youngest));
		
		people.stream()
			.max(Person::ageDifference)
			.ifPresent(eldest -> System.out.println("Eldest: " + eldest));
	}

}
