package java8.inaction.actionparameter.part5;

import java.util.ArrayList;
import java.util.List;

import java8.inaction.actionparameter.part4.Apple;

public class FilteringAppleTestMain {
	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<Apple>();
		appleList.add(new Apple("green", 156, false));
		appleList.add(new Apple("blue", 147, true));
		appleList.add(new Apple("red", 170, false));
		appleList.add(new Apple("blue", 132, true));
		appleList.add(new Apple("green", 155, true));
		appleList.add(new Apple("green", 149, true));
		
		List<Apple> resultList = FilteringApples.filter(appleList, (Apple apple) -> "red".equals(apple.getColor()));
		
		System.out.println(resultList.toString());
	}
}
