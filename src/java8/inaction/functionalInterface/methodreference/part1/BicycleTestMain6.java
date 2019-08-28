package java8.inaction.functionalInterface.methodreference.part1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java8.inaction.functionalInterface.Bicycle;

import static java.util.Comparator.comparing;
public class BicycleTestMain6 {

	public static void main(String[] args) {
		List<Bicycle> bicycleList = Arrays.asList(
				new Bicycle("scott", 175, "red"), 
				new Bicycle("giant", 173, "green"), 
				new Bicycle("elfama", 180, "white"),
				new Bicycle("specialized", 141, "red"),
				new Bicycle("stacato", 175, "red")
		);
		
		bicycleList.sort(comparing(Bicycle::getFrameSize));
		
		System.out.println(bicycleList.toString());
		
		bicycleList.sort(comparing(Bicycle::getFrameSize).reversed().thenComparing(Bicycle::getFrameSize));
		System.out.println(bicycleList.toString());
		
		List<Bicycle> bList = Arrays.asList(
				new Bicycle("scott", 175, "red"), 
				new Bicycle("giant", 173, "green"), 
				new Bicycle("elfama", 180, "white"),
				new Bicycle("specialized", 141, "red"),
				new Bicycle("stacato", 175, "red")
		);
		
		Predicate<Bicycle> redBicycle = b -> "red".equals(b.getColor());
		Predicate<Bicycle> notRedBicycle = redBicycle.negate();
		List<Bicycle> notRedBicycleList = bList.stream()
                .filter(notRedBicycle)
                .collect(Collectors.toList());
		System.out.println(notRedBicycleList.toString());
		
		List<Bicycle> cList = Arrays.asList(
				new Bicycle("scott", 175, "red"), 
				new Bicycle("giant", 173, "green"), 
				new Bicycle("elfama", 180, "white"),
				new Bicycle("specialized", 141, "red"),
				new Bicycle("stacato", 175, "red")
		);
		Predicate<Bicycle> rBicycle = b -> "red".equals(b.getColor());
		Predicate<Bicycle> redAndLongFrameBicycle = rBicycle.and(b -> b.getFrameSize() >= 175);
		List<Bicycle> redAndLongFrameBicycleList = cList.stream().filter(redAndLongFrameBicycle).collect(Collectors.toList());
		System.out.println(redAndLongFrameBicycleList.toString());
		
		List<Bicycle> dList = Arrays.asList(
				new Bicycle("scott", 175, "red"), 
				new Bicycle("giant", 173, "green"), 
				new Bicycle("elfama", 180, "white"),
				new Bicycle("specialized", 141, "red"),
				new Bicycle("stacato", 175, "red")
		);
		Predicate<Bicycle> redHeavyFreameBicycleOrGreen = redBicycle.and(b -> b.getFrameSize() >= 175).or(b -> "green".equals(b.getColor()));
		List<Bicycle> redHeavyFrameBicycleOrGreenList = dList.stream().filter(redHeavyFreameBicycleOrGreen).collect(Collectors.toList());
		System.out.println(redHeavyFrameBicycleOrGreenList);
	}

}
