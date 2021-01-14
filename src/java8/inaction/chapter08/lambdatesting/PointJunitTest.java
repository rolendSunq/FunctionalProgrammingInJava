package java8.inaction.chapter08.lambdatesting;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class PointJunitTest {
	// 익명 함수(람다)는 테스트 코드에서 이름을 호출할 수 없다!
	@Test
	public void testMoveRightBy() throws Exception {
		Point p1 = new Point(5, 5);
		Point p2 = p1.moveRightBy(10);
		
		assertEquals(15, p2.getX());
		assertEquals(5, p2.getY());
	}
	
	// 필요하다면 람다를 필드에 저장해서 재사용할 수 있으며 람다의 로직을 테스트할 수 있다.
	@Test
	public void testComparingTwoPoints() throws Exception {
		Point p1 = new Point(10, 15);
		Point p2 = new Point(10, 20);
		int result = Point.compareByXAndTheY.compare(p1, p2);
		assertEquals(-1, result);
	}
	
	@Test
	public void testMoveAllPointsRightBy() throws Exception {
		List<Point> points = Arrays.asList(new Point(5, 5), new Point(10, 5));
		List<Point> expectedPoints = Arrays.asList(new Point(15, 5), new Point(20, 5));
		List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);
		assertEquals(expectedPoints, newPoints);
	}
	
	// 함수를 인수로 받거나 다른 함수를 반환하는 메서드(고차 함수 high-order function)는
	// 테스트 하기에 어려움이 있다.
	// 메서드가 람다를 인수로 받는다면 다른 람다로 메서드의 동작을 테스트할 수 있다.
	@Test
	public void testFilter() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		List<Integer> even = numbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		List<Integer> smallerThanThree = numbers.stream().filter(i -> i < 3).collect(Collectors.toList());
		assertEquals(Arrays.asList(2, 4), even);
		assertEquals(Arrays.asList(1, 2), smallerThanThree);
	}
}
