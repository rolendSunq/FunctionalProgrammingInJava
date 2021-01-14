package java8.inaction.chapter08.lambdadebugging;

import java.util.Arrays;
import java.util.List;

import java8.inaction.chapter08.lambdatesting.Point;

public class Debugging {
	public static void main(String[] args) {
		// 람다로 작성한 경우 에러 발생시 스택 트레이스에 메서드 명이 표시되지 않는다.
		List<Point> points = Arrays.asList(new Point(12, 2), null);
		points.stream().map(p -> p.getX()).forEach(System.out::println);
		
		// 메서드 레퍼런스를 사용하는 클래스와 같은 곳에 선언되어 있는 메서드를 참조할 때
		// 메서드 레퍼런스의 이름이 스택트레이스에 나타난다.
		/*
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		numbers.stream().map(Debugging::divideByZero).forEach(System.out::println);
		 */
		
		// 람다 표현식과 관련된 스택 트레이스는 이해하기 어려울 수 있다.
		// 자바가 앞으로 개선할 문제이다.
	}
	
	public static int divideByZero(int n) {
		return n / 0;
	}
}
