package chapter3.part15.function_collect;

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
		
		List<Person> olderThan20 = new ArrayList<Person>();
		
		people.stream()
			.filter(person -> person.getAge() > 20)
			.forEach(person -> olderThan20.add(person));
		
		/*
		 * 타겟 컬렉션에 엘리먼트를 추가하는 오퍼레이션이 너무 로우 레벨이다.(?)
		 * 로우 레벨을 꺼내들어 많은 걸 생각하게 하는데 나의 주관적인 관점은
		 * 절차적인 코드로 진행되었다는 것을 나타낸 것으로 본다.
		 * 그러면 위의 코드를 풀어서 서술한다면 people 컬렉션을 이터레이션하여
		 * 나이가 20이상인 대상만 추출한 그룹을 다시 이터레이션 하여 olerThan20
		 * 컬렉션에 초기화한다.
		 * 여기서 각 절차에 대해 중복되는 코드가 나오는데 바로 이터레이션이 이중
		 * 으로 진행된다.
		 * 문제점은 이터레이션이 동시에 실행되며 스레드 세이프티 문제에 대해 고려
		 * 해야할 것이다. 이중 이터레이션은 병렬화를 어렵게 할 수 있다.
		 * 다음에 진행할 collect() 메소드 사용으로 문제점을 해결할 수 있다.
		 */
		
		System.out.println("People older than 20: " + olderThan20);
		
	}

}
