package java8.inaction.stream.chapter6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import java8.inaction.stream.Dish;

public class CollectorsUsingTestMain {

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
		
		List<Dish> dishes = menu.stream().collect(new ToListCollector<Dish>());
		System.out.println("dishes--->>>" + dishes);
		
		//기존 코드
		List<Dish> dishesII = menu.stream().collect(Collectors.toList());
		System.out.println("dishesII--->>>" + dishesII);
	}
	

}
