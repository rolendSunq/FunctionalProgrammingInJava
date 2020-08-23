package java8.inaction.stream.chapter6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import java8.inaction.stream.Dish;
import java8.inaction.stream.Dish.Type;

public class Reducing {

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
		
		int totalCalories = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
		
		System.out.println("totalCalories: " + totalCalories);
		
	}
	/**
	 * counting 컬렉터를 세 개의 인수를 갖는 reducing 팩토리 메서드를 이용하여 구현할 수 있다.
	 * long 객체 형식의 요소를 1로 변환한 다음 모두 더할 수 있다.
	 */
	public static <T> Collector<T, ?, Long> counting() {
		return Collectors.reducing(0L, e -> 1L, Long::sum);
	}
	

}
