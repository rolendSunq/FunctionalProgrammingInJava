package java8.inaction.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 기본형 특화 스트림은 박싱 비용을 피할 수 있도록 int -> IntStream,
 * double -> DoubleStream, long -> LongStream등을 제공한다.
 * sum, max, min과 같이 자주 사용하는 숫자 관련 리듀싱 연산 수행 메소드를
 * 제공하며, 필요한 때에 다시 객체 스트림으로 복원하는 기능도 제공한다.
 * 특화 스트림은 '오직 박싱 과정에서 일어나는 효율성과 관련 있으며 스트림에 
 * 추가 기능을 제공하지 않는 점을 기억하자'
 * @author DevJune
 *
 */
public class PrimitiveStreamSpecialization {

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
		
		/**
		 * mapToInt 메서드는 각 요리에서 모든 칼로리(Integer 형식)를 추출한 다음
		 * IntStream을 (Stream<Integer>가 아님) 반환한다.
		 * IntStream 인터페이스에서 제공하는 sum 메소드를 이용해서 칼로리 총 합계를 
		 * 계산할 수 있으며 스트림이 비어있으면 0을 리턴한다. max, min average등 
		 * 다양한 메소드를 지원한다.
		 */
		
		int calories = menu.stream()			// Stream<Dish> 반환
				.mapToInt(Dish::getCalories)	// IntStream 반환
				.sum();
		
		System.out.println("모든 요리의 칼로리 총합 ===> " + calories);
		
		/**
		 * 객체 스트림으로 복원하기
		 * 숫자 스트림을 만든 후, 원상태인 특화되지 않은 스트림으로 복원이 가능할까?
		 * 예를 들어 IntStream은 원시타입의 정수값만 만들수 있다. IntStream의 map 연산은
		 * 'int를 인수로 받아서 int를 반환하는 람다(IntUnaryOperator)'를 인수로 받는다.
		 * 하지만 정수가 아닌 Dish 같은 다른 type을 반환을 해야할 경우는 어떻게 할 것 인가?
		 * 반환하려면 스트림 인터페이스에 정의된 일반적인 연산을 사용해야 한다. 
		 * 이런 경우 boxed 메소드를 이용하여 특화 스트림을 일반 스트림으로 변환할 수 있다.
		 */
		
		// 스트림을 숫자 스트림으로 변환
		IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
		
		// 숫자 스트림을 스트림으로 변환
		Stream<Integer> stream = intStream.boxed();
		
		System.out.print("변환된 스트림의 값 출력 ===>");
		stream.forEach(a -> System.out.print(" " + a));
		System.out.println();
		
		/**
		 * 데이터에 기본값이 설정이 되어있다면 문제는 없지만 설정이 안된경우는 그 값을 어떻게
		 * 표현하는 것이 문제가 될 수 있다. IntStream에서 최댓값을 찾을때 0으로 기본
		 * 값이 될 경우 잘못된 결과로 될 수 있다. Optional은 Integer, String등의 레퍼런스
		 * 형식으로 파라미터화할 수 있다. 또한 특화 스트림과 같이 OptionalInt, 
		 * OptionalDouble, OptionalLong 세 가지 기본형 특화 스트림도 있다.
		 */
		
		// OptionalInt를 이용하여 IntStream의 최댓값을 얻을 수 있다.
		OptionalInt maxCalories = menu.stream()
				.mapToInt(Dish::getCalories)
				.max();
		
		System.out.println("메뉴 요리의 최대 칼로리 ===> " + maxCalories);
		
		/**
		 * 1 ~ 100 사이의 수에서 특정 범위의 숫자에 대해 Java 8에서 IntStream과 
		 * LongStream에서는 2개의 정적 메서드를 제공한다. rangeClosed, range 이 메서드들은 
		 * 첫번째 인자로 시작값을 두번째 인자값으로 종료값을 갖는다.
		 * range 메서드는 시작값과 종료값을 포함하지 않는 반면 rangeClosed는 시작값과 종료 값이
		 * 포함된다.
		 */
		IntStream evenNumbers  = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
		System.out.println(evenNumbers.count());
		
		Stream<int[]> pythagoreanTriples = 
		IntStream.rangeClosed(1, 100).boxed()
			.flatMap(a ->
				IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
				.mapToObj(b -> new int[] {a, b, (int) Math.sqrt(a * a + b * b)}));
		
		pythagoreanTriples.limit(10).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
		
		Stream<double[]> pythagoreanTriple2 = 
		IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100)
				.mapToObj(b -> new double[] {a, b, Math.sqrt(a * a + b * b)})
				.filter(t -> t[2] % 1 == 0));
		
		pythagoreanTriple2.limit(20).forEach(d -> System.out.println(d[0] + ", " + d[1] + ", " + d[2]));
		
	}
	
}
