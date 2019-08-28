package java8.inaction.functionalInterface.stream.part1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import java8.inaction.functionalInterface.Dish;
import static java.util.Comparator.comparing;

public class StreamBasic1TestMain {

	public static void main(String[] args) {
		List<Dish> dishes = Arrays.asList(
			new Dish("muffin", 301),
			new Dish("saewookkang", 419),
			new Dish("vegetable croquette", 310),
			new Dish("sliced bread", 210),
			new Dish("garlic bread", 65),
			new Dish("hard roll", 121),
			new Dish("jocbal", 768),
			new Dish("Sweet and sour pork", 481)
		);
		
		List<String> lowCaloricDishesName = dishes.stream()
				.filter(d -> d.getCalories() < 400)
				.sorted(comparing(Dish::getCalories))
				.map(Dish::getName)
				.collect(Collectors.toList());
		
		System.out.println(lowCaloricDishesName.toString());
		
		List<String> lowCaloricDishesName2 = dishes.parallelStream()
				.filter(d -> d.getCalories() < 400)
				.sorted(comparing(Dish::getCalories))
				.map(Dish::getName)
				.collect(Collectors.toList());

		System.out.println(lowCaloricDishesName2.toString());
	}

}
