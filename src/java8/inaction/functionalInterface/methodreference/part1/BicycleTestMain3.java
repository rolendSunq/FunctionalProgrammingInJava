package java8.inaction.functionalInterface.methodreference.part1;

import java.util.Arrays;
import java.util.List;

import java8.inaction.functionalInterface.Bicycle;

public class BicycleTestMain3 {

	public static void main(String[] args) {
		List<Bicycle> bicycleList = Arrays.asList(
				new Bicycle("scott", 175), 
				new Bicycle("giant", 173), 
				new Bicycle("elfama", 180),
				new Bicycle("specialized", 141),
				new Bicycle("stacato", 175)
		);
		
		bicycleList.sort((Bicycle b1, Bicycle b2) -> b1.getFrameSize().compareTo(b2.getFrameSize()));
		
		System.out.println(bicycleList.toString());
	}

}
