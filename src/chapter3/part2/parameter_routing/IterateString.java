package chapter3.part2.parameter_routing;

public class IterateString {

	public static void main(String[] args) {
		final String str = "w00t";
		
		// 메서드 레퍼런스 System.out에 대해 호출한다. 메서드 레퍼런스에서 더블콜론 왼쪽의
		// 클래스 이름이나 표현식을 사용할 수 있다.
		// 람다 표현식과 메서드 레퍼런스가 함수형 인터페이스에 대한 구현을 대체한다는 것을 기억하자.
		str.chars().forEach(System.out::println);
	}

}
