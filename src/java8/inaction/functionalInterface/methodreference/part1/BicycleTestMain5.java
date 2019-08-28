package java8.inaction.functionalInterface.methodreference.part1;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;

import java8.inaction.functionalInterface.Bicycle;

public class BicycleTestMain5 {

	public static void main(String[] args) {
		List<Bicycle> bicycleList = Arrays.asList(
				new Bicycle("scott", 175), 
				new Bicycle("giant", 173), 
				new Bicycle("elfama", 180),
				new Bicycle("specialized", 141),
				new Bicycle("stacato", 175)
		);
		
		//Comparator<Bicycle> comparator = Comparator.comparing((Bicycle bicycle) -> bicycle.getFrameSize());
		
		bicycleList.sort(comparing((a) -> a.getFrameSize()));
		
		System.out.println(bicycleList.toString());
	}

}
