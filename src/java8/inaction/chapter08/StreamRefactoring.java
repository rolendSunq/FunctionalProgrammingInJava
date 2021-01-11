package java8.inaction.chapter08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import java8.inaction.stream.Dish;

public class StreamRefactoring {
	/**
	 * 명령형 데이터 처리를 스트림으로 리팩토링하기
	 * 스트림 API는 데어터 처리 파이프라인의 의도를 더 명확하게 나타낸다.
	 * 쇼트서킷, Lazy, 멀티코어 아키텍처를 활용할 수 있는 지름길을 제공한다.
	 */
	
	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("checken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));
		
		// 필터링과 추출로 구성된 코드는 전체 구현을 살펴봐야 코드의 의도를 알수있다.
		// 병렬로 실행할 수 있게 리팩토링 작업을 하기에 어렵다.
		List<String> dishNames = new ArrayList<>();
		for (Dish dish : menu) {
			if (dish.getCalories() > 300) {
				dishNames.add(dish.getName());
			}
		}
		
		System.out.println("dishNames--->>> " + dishNames);
		
		// 스트림 API로 직관적이며 쉽게 병렬화할 수 있다.
		List<String> dishNamesII = menu.parallelStream()
				.filter(d -> d.getCalories() > 300)
				.map(Dish::getName)
				.collect(Collectors.toList());
		System.out.println("dishNamesII--->>> " + dishNamesII);
		
		/**
		 * 명령형 코드의 break, continue, return 등의 제어 흐름문을 모두 분석하여
		 * 같은 기능을 수행하는 stream 연산으로 유추해야 하며 
		 * 명령형 코드를 stream API로 바꾸는 것은 쉽지않다.
		 * 하지만 명령형 코드를 stream API로 바꾸도록 도와주는 몇가지 도구가 있다.
		 */
	}
}
