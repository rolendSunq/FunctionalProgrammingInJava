package java8.inaction.functionalInterface.methodreference.part1;

import java.util.Arrays;
import java.util.List;

import java8.inaction.functionalInterface.Bicycle;

public class BicycleTestMain {

	public static void main(String[] args) {
		List<Bicycle> bicycleList = Arrays.asList(new Bicycle("scott", 175), new Bicycle("giant", 173), new Bicycle("elfama", 180));
		bicycleList.sort(new BicycleComparator());
		System.out.println(bicycleList.toString());
	}

}
