package java8.inaction.actionparameter.part3;

import java.util.ArrayList;
import java.util.List;

public class FilteringGreenApple {
	
	public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
				result.add(apple);
			}
		}
		return result;
	}
}
