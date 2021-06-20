package currying.part03;

public class Currier0Using {
	public static void main(String[] args) {
		String direct = Currier0.concat("hello", 12345, 67890);
		System.out.println("Currier0.concat(\"hello\", 12345, 67890): " + direct);
		
		String curried = Currier0.curry()
				.apply("hello")
				.apply(12345)
				.apply(67890);
		System.out.println("curry(): " + curried);
	}
}
