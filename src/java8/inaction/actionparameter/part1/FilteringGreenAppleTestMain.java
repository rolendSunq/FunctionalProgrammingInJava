package java8.inaction.actionparameter.part1;

import java.util.ArrayList;
import java.util.List;

public class FilteringGreenAppleTestMain {
	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<Apple>();
		appleList.add(new Apple("green"));
		appleList.add(new Apple("blue"));
		appleList.add(new Apple("red"));
		appleList.add(new Apple("blue"));
		appleList.add(new Apple("green"));
		appleList.add(new Apple("green"));
		List<Apple> resultList = FilteringGreenApple.filterGreenApples(appleList);
		
		System.out.println(resultList.toString());
		
		List<Apple> resultList2 = FilteringGreenApple.filterAppleByColor(appleList, "blue");
		
		System.out.println(resultList2.toString());

		List<Apple> resultList3 = FilteringGreenApple.filterAppleByColor(appleList, "green");
		
		System.out.println(resultList3.toString());
	}
}
