package java8.inaction.functionalInterface.consumer.part1;

import java.util.Arrays;
import java.util.List;

public class ConsumerFilterTestMain {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
		
		ConsumerFilter.forEach(numList, (Integer i) -> System.out.println(i));
	}

}
