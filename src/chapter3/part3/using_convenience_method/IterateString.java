package chapter3.part3.using_convenience_method;

public class IterateString {

	private static void printChar(int aChar) {
		System.out.println((char)(aChar));
	}
	
	public static void main(String[] args) {
		final String str = "w00t";
		str.chars().forEach(IterateString::printChar);
	}

}
