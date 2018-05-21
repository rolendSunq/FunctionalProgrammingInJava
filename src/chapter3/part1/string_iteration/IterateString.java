package chapter3.part1.string_iteration;

public class IterateString {
	
	public static void main(String[] args) {
		final String str = "w00t";
		
		// chars() 메서드는 CharSequence 인터페이스로부터 파생한 String 클래스에 있는 새로운 메서드이다.
		// convenient internal iterator(편리한 내부 반복자)를 사용하여 스트링을 구성하는 개별적 문자들에 
		// 대해 오퍼레이션을 적용할 수 있다.
		str.chars().forEach(ch -> System.out.println(ch));
	}
}
