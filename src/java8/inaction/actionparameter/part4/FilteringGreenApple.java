package java8.inaction.actionparameter.part4;

import java.util.ArrayList;
import java.util.List;

public class FilteringGreenApple {
	
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate applePredicate) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (applePredicate.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}
