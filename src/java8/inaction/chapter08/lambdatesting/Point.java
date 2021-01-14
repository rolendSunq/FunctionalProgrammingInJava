package java8.inaction.chapter08.lambdatesting;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Point {
	// unit testing 에서 람다는 익명 함수로 호출이 불가능하다.
	// 필요에 의해 람다를 필드에 저장해서 테스팅으로 재사용이 가능하다.
	public final static Comparator<Point> compareByXAndTheY 
		= Comparator.comparing(Point::getX).thenComparing(Point::getY);
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Point moveRightBy(int x) {
		return new Point(this.x + x, this.y);
	}
	
	public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
		return points.stream().map(p -> new Point(p.getX() + x, p.getY())).collect(Collectors.toList());
	}
	
	
}
