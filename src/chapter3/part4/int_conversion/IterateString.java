package chapter3.part4.int_conversion;

public class IterateString {
	
	public static void main(String[] args) {
		final String str = "w00t";
		
		str.chars().mapToObj(ch -> Character.valueOf((char)ch)).forEach(System.out::println);
	}

}
