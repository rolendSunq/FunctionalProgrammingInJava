package java8.inaction.actionparameter.part2;

import java.util.ArrayList;
import java.util.List;

public class FilteringGreenAppleTestMain {
	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<Apple>();
		appleList.add(new Apple("green", 156));
		appleList.add(new Apple("blue", 147));
		appleList.add(new Apple("red", 170));
		appleList.add(new Apple("blue", 132));
		appleList.add(new Apple("green", 155));
		appleList.add(new Apple("green", 149));
		
		List<Apple> resultList = FilteringGreenApple.filterApplesByWeight(appleList, 150);
		
		System.out.println(resultList.toString() );
	}
}
