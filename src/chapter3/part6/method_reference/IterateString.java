package chapter3.part6.method_reference;

public class IterateString {
	private static void printChar(int aChar) {
		System.out.println((char)(aChar));
	}
	
	public static void main(String[] args) {
		final String str = "w00t";
		
		// filter(), forEach() 메서드에 전달하는 람다 표현식 대신 각 메서드에 대한 레퍼런스를
		// 사용할 수 있음을 다시 한번 상기하도록 하자.
		str.chars().filter(Character::isDigit).forEach(IterateString::printChar);
		
	}

	/*
	 * 
	 */
}