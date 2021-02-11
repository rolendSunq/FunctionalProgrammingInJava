package java8.inaction.chapter13.part03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.LongStream;

import org.junit.Test;

import java8.inaction.actionparameter.part5.Apple;

public class RecursiveRepeat {
	/*
	 * 재귀와 반복
	 * 
	 * 순수 함수형 프로그래밍 언어에서 while, for 와 같은 반복문을 포함하지 않는다.
	 * 그 이유는 변화가 자연스럽게 코드에 스며들 수 있기 때문이다.
	 * loop 문의 조건절을 변경해서 안전하게 loop 를 종료하거나 loop 미실행을 할 수 있다.
	 * 함수형 스타일에서는 다른 누군가가 변화를 알아차리지 못하면 아무 상관 없다.
	 * 따라서 지역 변수는 자유롭게 갱신할 수 있다.
	 * while 바디 내부에서 apple 변수에 할당하는 동작을 할 수 있다.
	 */
	
	@Test
	public void iteratorUsing() {
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple("green", 156, false));
		apples.add(new Apple("blue", 147, true));
		apples.add(new Apple("red", 170, false));
		apples.add(new Apple("blue", 132, true));
		apples.add(new Apple("green", 155, true));
		apples.add(new Apple("green", 149, true));
		
		Iterator<Apple> it = apples.iterator();
		int totalWeight = 0;
		
		while (it.hasNext()) {
			Apple apple = it.next();
			totalWeight += apple.getWeight();
		}
		
		System.out.println("total apple weight: " + totalWeight);
	}
	
	/*
	 * for-each 루프를 사용하는 검색 알고리즘은 문제가 있다.
	 * 
	 * 루프의 바디에서 함수형과 상충하는 부작용이 발생한다. 즉, 루프에서 프로그램의 다른 부분과 
	 * 공유되는 stats 객체의 상태를 변화시킨다.
	 */
	public static void searchForGold(List<String> l, Stats stats) {
		for (String s : l) {
			if ("gold".equals(s)) {
				stats.incrementFor("gold");
			}
		}
	}
	
	/*
	 * 이론적으로 반복을 이용하는 모든 프로그램은 재귀로도 구현할 수 있는데 재귀를 이용하면 변화가
	 * 일어나지 않는다. 재귀를 이용하면 루프 단계마다 갱신되는 반복 변수를 제거할 수 있다.
	 * 
	 * 다음은 팩토리얼 함수로, 반복과 재귀방식으로 해결할 수 있는 고전적 학교 문제다.
	 * 입력은 1보다 크다고 가정한다.
	 */
	public static int factorialIterative(int n) {
		int r = 1;
		
		for (int i = 1; i <= n; i++) {
			r *= i;
		}
		
		return r;
	}
	
	/*
	 *  재귀 방식의 팩토리얼
	 */
	public static long factorialRecursive(long n) {
		return n == 1 ? 1 : n * factorialRecursive(n - 1);
	}
	
	/* 스트림 팩토리얼
	 * 일반적으로 반복 코드보다 재귀 코드가 더 비싸다. 
	 * 그 이유는 factorialRecursive 함수를 호출할 때마다 호출 스택에 각 호출시
	 * 생성되는 정보를 저장하는 새로운 스택 프레임이 만들어진다. 
	 * 즉, 재귀 팩토리얼의 입력 값에 비례해서 메모리 사용량이 증가한다.
	 * 따라서 큰 입력값을 사용하면 StackOverflowError가 발생한다.
	 */
	public static long factorialStreams(long n) {
		return LongStream.rangeClosed(1, n).reduce(1, (long a, long b) -> a * b);
	}
	
	/*
	 * 함수형 언어에서는 꼬리 호출 최적화(tail-call optimization) 
	 */
	public static long factorialTailRecursive(long n) {
		return factorialHelper(1, n);
	}

	public static long factorialHelper(int acc, long n) {
		return n == 1 ? acc : factorialHelper((int)(acc * n), n - 1);
	}
}
