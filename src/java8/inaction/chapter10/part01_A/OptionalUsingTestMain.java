package java8.inaction.chapter10.part01_A;

import java.util.Optional;

public class OptionalUsingTestMain {

	public static void main(String[] args) {
		String text = "Guns Akimbo";
		Optional<String> maybeText = Optional.ofNullable(text);
		int length;
		if (maybeText.isPresent()) {
			length = maybeText.get().length();
		} else {
			length = 0;
		}
		
		System.out.println("length--->>> " + length);
	}

}
