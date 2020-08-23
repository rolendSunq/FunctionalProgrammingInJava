package java8.inaction.stream;

import java.util.Arrays;
import java.util.List;

/**
 * stream에서 요소들의 합을 구하는 방법 중 reduce 메서드를 사용하는 방법이 있다.
 * @author DevJune
 *
 */
public class NumberTypeStream {
	
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
		
		// reduce 메소드에서 Integer를 기본형으로 언박싱해야 한다. 
		int calories = menu.stream()
				.map(Dish::getCalories)
				.reduce(0, Integer::sum);
		
		System.out.println("메뉴의 칼로리 총합 ===> " + calories);

		// 언박싱을 피하기 위해 직접 sum 메소드를 호출할 수 있다.
		// 위의 reduce 메소드를 이용한 것 처럼 map 메소드 후 sum 메소드를 
		// 호출 해야 하나, map 메소드는 Stream<T>를 생성하기 때문에 sum 메소드를 
		// 직접 호출할 수 없다. reduce 메소드를 이용한 stream에서 스트림의 요소는
		// Integer이지만 인터페이스에는 sum 메소드가 없다. 당연히 Stream<Dish>
		// 와 같은 형식의 요소가 있다면 sum 연산을 수행할 수 없다. 
		// 다행히도 스트림 API 숫자 스트림을 효율적으로 처리할 수 있게 기본형 특화 
		// 스트림(primitive stream specialization)을 제공한다.
		int calories2 = menu.stream()
				.mapToInt(Dish::getCalories)
				.sum();
		
		System.out.println("메뉴의 칼로리 총합(sum 메소드 사용) ===> " + calories2);
	}
}
