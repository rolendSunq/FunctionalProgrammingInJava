package java8.inaction.actionparameter.part2;

import java.util.ArrayList;
import java.util.List;

public class FilteringGreenApple {
	
	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}
}
