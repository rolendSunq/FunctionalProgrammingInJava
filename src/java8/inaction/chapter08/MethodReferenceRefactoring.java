package java8.inaction.chapter08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java8.inaction.actionparameter.part4.Apple;
import java8.inaction.stream.Dish;
import java8.inaction.stream.chapter6.CaloricLevel;

public class MethodReferenceRefactoring {
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
		
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
				Collectors.groupingBy(dish -> {
					if (dish.getCalories() <= 400) return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
					else return CaloricLevel.FAT;
				}));
		
		System.out.println("dishesByCaloricLevel--->>>" + dishesByCaloricLevel);
		
		// 람다 표현식을 별도의 메서드로 추출한 다음에 groupingBy에 인수로 전달할 수 있다.
		// 코드가 간결하고 의도도 명확하다.
		Map<CaloricLevel, List<Dish>> dishesByCaloricalLevelII = menu.stream().collect(Collectors.groupingBy(Dish::getCaloricLevel));
		System.out.println("dishesByCaloricalLevelII--->>" + dishesByCaloricalLevelII);
		
		// comparing과 maxBy 같은 정적 핼퍼 메서드를 활용하는 것도 좋다.
		// 이들은 메서드 레퍼런스와 조화를 이루도록 설계되었다.
		// 아래 코드는 람다 표현식 보다 메서드 레퍼런스가 코드의 의도를 잘 보여준다.
		List<Apple> inventory = new ArrayList<Apple>();
		inventory.add(new Apple("green", 156, false));
		inventory.add(new Apple("blue", 147, true));
		inventory.add(new Apple("red", 170, false));
		inventory.add(new Apple("blue", 132, true));
		inventory.add(new Apple("green", 155, true));
		inventory.add(new Apple("green", 149, true));
		
		// 비교 구현에 신경써야 한다.
		inventory.sort((Apple a1, Apple a2) -> new Integer(a1.getWeight()).compareTo(a2.getWeight()));
		System.out.println("inventory--->>>" + inventory);
		
		// 메서드 레퍼런스 사용. 코드가 문제 자체를 설명한다(?...).
		Collections.sort(inventory, Comparator.comparing(Apple::getWeight));
		
		/**
		 * sum, maximum 등 자주 사용하는 리듀싱 연산은 메서드 레퍼런스와 함께 사용할 수 있는
		 * 내장 헬퍼 메서드를 제공한다. 최댓값, 합계등을 계산할 때  람다 표현식과 저수준 
		 * 리듀싱 연산을 조합하는 것보다 Collectors API를 사용하면 코드의 의도가 더 명확하다.
		 */
		// 저수준 리듀싱 연산을 조합한 코드
		int totalCalories = menu.stream().map(Dish::getCalories).reduce(0, (c1, c2) -> c1 + c2);
		System.out.println("totalCalories--->>> " + totalCalories);
		
		// 내장 컬랙터를 이용하면 코드로 의도를 더 명확하게 설명할 수 있다.
		// summingInt를 사용하여 자신이 어떤 동작을 수행하는지 메소드 이름으로 알 수 있다.
		int totalCaloriesII = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		System.out.println("totalCaloriesII--->>> " + totalCaloriesII);
	}
}
