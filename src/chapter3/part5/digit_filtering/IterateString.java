package chapter3.part5.digit_filtering;

public class IterateString {

	private static void printChar(int aChar) {
		System.out.println((char)(aChar));
	}

	public static void main(String[] args) {
		final String str = "w00t";
		
		// chars() 메서드를 리턴하는 스트림에 대해 내부 이터레이터를 사용했다.
		// chars() 메서드는 사용함에 있어 별도의 제약은 없다.
		// 스트림을 얻게되면 스트림에서 제공하는 메서드를 이용하여 스트링에 있는 문자들을 처리할 수 있다.
		// 예) filter(), map(), reduce()
		// filter() 메서드를 이용하여 스트링에서 숫자로 필터링 할 수 있다.
		str.chars().filter(ch -> Character.isDigit(ch)).forEach(ch -> printChar(ch));
	}

}
