 package java8.inaction.stream.chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import java8.inaction.stream.Dish;

public class Grouping {
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
		
		Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
		
		System.out.println("dishesByType-->>" + dishesByType);
		
		// 서브그룹으로 데이터 수집
		// groupingBy의 두번째 인자로 counting 컬렉터를 전달해서 메뉴에서 요리의 수를 종류별로 계산할 수 있다.
		Map<Dish.Type, Long> typesCount = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
		System.out.println("typesCount--->>>" + typesCount);
		
		// 요리의 종류를 분류하고 가장 높은 칼로리를 가진 요리로 찾을 수 있다.
		Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
		System.out.println("mostCaloricByType--->>>" + mostCaloricByType);
		
		Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream().collect(
				Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
					if (dish.getCalories() <= 400) {
						return CaloricLevel.DIET;
					} else if (dish.getCalories() <= 700) {
						return CaloricLevel.NORMAL;
					} else {
						return CaloricLevel.FAT;
					}
				}, Collectors.toSet())));
		
		System.out.println("caloricLevelsByType--->>>" + caloricLevelsByType);
		
		Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByTypeII = menu.stream().collect(
				Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
					if (dish.getCalories() <= 400) {
						return CaloricLevel.DIET;
					} else if (dish.getCalories() <= 700) {
						return CaloricLevel.NORMAL;
					} else {
						return CaloricLevel.FAT;
					}
				}, Collectors.toCollection(HashSet::new))));
		
		System.out.println("caloricLevelsByTypeII--->>>" + caloricLevelsByTypeII);
		
		// 분할
		Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(
				Collectors.partitioningBy(Dish::isVegiterian)
				);
		System.out.println("partitionedMenu--->>>" + partitionedMenu);
		List<Dish> vegetarianDishes = partitionedMenu.get(true);
		System.out.println("vegetarianDishes--->>>" + vegetarianDishes);
	}
}
