package java8.inaction.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InnerIteratorMain {

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("checken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));
		
		List<String> threeHighCaloricDishNames = menu.stream()
				.filter(d -> d.getCalories() > 300)
				.map(Dish::getName)
				.limit(3)
				.collect(Collectors.toList());
		System.out.println(threeHighCaloricDishNames);
		
		List<Dish> vegetarianDishes = menu.stream()
				.filter(Dish::isVegiterian)
				.collect(Collectors.toList());
		System.out.println(vegetarianDishes);
		
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream()
			.filter(i -> i % 2 == 0)
			.distinct()
			.forEach(System.out::println);
		
		List<Dish> twoMeatDishList = menu.stream()
				.filter(d -> d.getType() == Dish.Type.MEAT)
				.limit(2)
				.collect(Collectors.toList());
		System.out.println(twoMeatDishList);
		
		List<String> dishNames = menu.stream()
				.map(Dish::getName)
				.collect(Collectors.toList());
		
		System.out.println("dishNames ===>" + dishNames);
		
		List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		List<Integer> wordLengths = words.stream()
				.map(String::length)
				.collect(Collectors.toList());
		
		System.out.println("wordLengths===>" + wordLengths);
		
		List<Integer> dishNameLengths = menu.stream()
				.map(Dish::getName)
				.map(String::length)
				.collect(Collectors.toList());
		
		System.out.println("dishNameLengths===>" + dishNameLengths);
		
		
		List<String> basicWords = Arrays.asList("Hello", "World");
		
		List<String[]> flatWord = basicWords.stream()
				.map(word -> word.split(""))
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println("flatWord===>" + flatWord.toString());
		for (String[] strArr : flatWord) {
			for (String str : strArr) {
				System.out.print(str);
			}
		}
		
		String[] arrayOfWords = {"Goobye", "World"};
		@SuppressWarnings("unused")
		Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
		
		List<Stream<String>> words2 = basicWords.stream()
				.map(word -> word.split(""))
				.map(Arrays::stream)
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println("words2===>" + words2);
		
		List<String> uniqueCharacters = basicWords.stream()
				.map(word -> word.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println("uniqueCharacters===>" + uniqueCharacters);
		
		List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> square = numbers2.stream()
				.map(n -> n * n)
				.collect(Collectors.toList());
		
		System.out.println("square===>" + square);
		
		List<Integer> squareTwo = numbers2.stream()
				.map(x -> ((int) Math.pow(x, 2)))
				.collect(Collectors.toList());
		System.out.println("squareTwo===>" + squareTwo);
		
		List<Integer> numbersOne = Arrays.asList(1, 2, 3);
		List<Integer> numbersTwo = Arrays.asList(3, 4);
		
		List<int[]> numbersCombination = numbersOne.stream()
				.flatMap(x -> numbersTwo.stream()
						.map(y -> new int[] {x, y}))
				.collect(Collectors.toList());
		System.out.println("numbersCombination===> " + numbersCombination);
		
		List<String> names = menu.stream()
				.filter(d -> {
					System.out.println("filtering" + d.getName());
					return d.getCalories() > 300;
				})
				.map(d -> {
					System.out.println("mapping" + d.getName());
					return d.getName();
				})
				.limit(3)
				.collect(Collectors.toList());
		System.out.println(names); 
		
		menu.stream()
				.filter(Dish::isVegiterian)
				.findAny()
				.ifPresent(d -> System.out.println(d.getName()));
		
		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
				.map(x -> (int) Math.pow(x, 2))
				.filter(x -> x % 3 == 0)
				.findFirst();
		
		System.out.println("firstSquareDivisibleByThree" + firstSquareDivisibleByThree);
		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		System.out.println("max Of numbers ===> " + max);
		
		Optional<Integer> min = numbers.stream().reduce(Integer::min);
		System.out.println("min Of Numbers ===> " + min);
		
		int count = menu.stream().map(d -> 1)
				.reduce(0, (a, b) -> a + b);
		
		System.out.println("menu count ===> " + count);
		
		int sum  = numbers.parallelStream().reduce(0, Integer::sum);
		
		System.out.println("numbers sum ===> " + sum);
	}

}
