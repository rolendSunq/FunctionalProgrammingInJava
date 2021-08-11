package consumer_interface.part05;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

public class PracticeConsumer01 {
	@Test
	public void arraysUpper() {
		List<String> fruits = Arrays.asList(
				"banana",
				"lemon",
				"apple",
				"pineapple",
				"grape",
				"kiwi",
				"peach",
				"apple",
				"melon",
				"banana",
				"peach",
				"kiwi",
				"apple",
				"lemon",
				"water melon",
				"lemon",
				"apple",
				"grape"
				);
		
		Consumer<List<String>> consumer = (f) -> {
			for (String s : f) {
				System.out.println(s.toUpperCase());
			}
		};
		
		consumer.accept(fruits);
	}
}
