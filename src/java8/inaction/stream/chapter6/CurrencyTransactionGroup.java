package java8.inaction.stream.chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import java8.inaction.stream.Dish;
import java8.inaction.stream.trader.Trader;
import java8.inaction.stream.trader.Transaction;

public class CurrencyTransactionGroup {

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
		
		long howManyDishes = menu.stream().collect(Collectors.counting());
		
		System.out.println("howManyDishes: " + howManyDishes);
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactionList = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
		
		List<Transaction> transactions = transactionList.stream().collect(Collectors.toList());
		
		System.out.println(transactions);
		
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		
		Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
		
		System.out.println(mostCalorieDish);
		
		int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		
		System.out.println(totalCalories);
		
		double avgCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
		
		System.out.println(avgCalories);
		
		/**
		 * Collectors의 joining 팩토리 메서드를 이용하면 스트림의 각 객체에 toString메서드를 호출해서
		 * 추출한 모든 문자열을 하나의 문자열로 연결해서 반환한다.
		 * joining 메서드는 내부적으로 StringBuilder를 이용해서 문자열을 하나로 만든다.
		 * 문자열 결과가 공백과 구분자가 없이 나오기 때문에 문자열을 해석할 수 없다. 
		 * 각 요소 사이에 문자열을 넣을 수 있도록 오버로드 된 joining 팩토리 메서드도 있다.
		 */
		String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining());
		
		System.out.println(shortMenu);
		
		String advancedShortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
		
		System.out.println(advancedShortMenu);
		
		int totCal = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
		
		System.out.println(totCal);
		
	}
}
