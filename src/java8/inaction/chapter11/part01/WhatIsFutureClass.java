package java8.inaction.chapter11.part01;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class WhatIsFutureClass {
	/*
	 * Future클래스는 비동기 처리 결과를 사용하기 위한 클래스이다.
	 * 비동기 처리에 대해 완료, 대기, 완료 결과에 대한 메소드가 있다.
	 * Future의 비동기 작업을 활용하는 몇가지 예
	 * 계산 집약적 프로세스(수학적 및 과학적 계산)
	 * 대규모 데이터 구조 조작 (빅 데이터)
	 * 원격 메소드 호출(파일 다운로드, HTML스크랩, 웹 서비스)
	 */
	
	@Test
	public void squareCalc() throws InterruptedException, ExecutionException {
		SquareCalculator sc = new SquareCalculator();
		Future<Integer> result = sc.calculate(7);
		int squareResult = result.get();
		assertEquals(49, squareResult);
	}
	
	@Test
	public void factorialCalculator_run() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		List<Map<Integer, Future<BigInteger>>> resultList = new ArrayList<>();
		Random random = new Random();
		
		for (int i = 0; i < 6; i++) {
			int number = random.nextInt(100) + 10;
			FactorialCalculator fc = new FactorialCalculator(number);
			
			Map<Integer, Future<BigInteger>> result = new HashMap<>();
			result.put(number, executor.submit(fc));
			resultList.add(result);
		}
		
		for (Map<Integer, Future<BigInteger>> pair : resultList) {
			Optional<Integer> optional = pair.keySet().stream().findFirst();
			
			if (!optional.isPresent()) {
				return;
			}
			
			int key = optional.get();
			
			System.out.printf("Value is: %d\n", key);
			
			Future<BigInteger> future = pair.get(key);
			BigInteger result = future.get();
			boolean isDone = future.isDone();
			
			System.out.printf("Result is %d\n", result);
			System.out.printf("Task done: %b\n", isDone);
			System.out.printf("------------------------\n");
		}
		
		executor.shutdown();
	}
}
