package java8.inaction.actionparameter.part1;

import java.util.ArrayList;
import java.util.List;

public class FilteringGreenApple {
	
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		
		return result;
	}
	
	public static List<Apple> filterAppleByColor(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (apple.getColor().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}
}
