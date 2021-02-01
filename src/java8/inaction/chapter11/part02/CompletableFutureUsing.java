package java8.inaction.chapter11.part02;

import java.util.concurrent.Future;

import org.junit.Test;

public class CompletableFutureUsing {
	/*
	 * CompletableFuture로 비동기 애플리케이션 만들기
	 * 예제로 가장 저렴한 가격을 제시하는 온라인 상점을 찾는 애플리케이션을 만드는 것을 목표로 한다.
	 * CompletableFuture 객체의 기능을 제시한다.
	 * 1. 고객에게 비동기 API를 제공하는 방법을 배운다.(온라인 상점을 운영하고 있는 독자에게 유용한 기술)
	 * 2. 동기 API를 실행시 코드를 비블록으로 만들어야 한다.
	 *  - 두 개의 비동기 동작을 파이프라인 만든다.
	 *  - 두 개의 비동기 계산으로 합치는 방법을 만든다.
	 *  - 판매 물건의 할인 코드 -> 원격 할인 서비스의 할인 코드 조회 -> 할인율 검색 -> 할인율 결과 -> 가격에 할인율 적용
	 * 3. 비동기 동작의 완료에 대한 대응 방법
	 *  - 모든 상점의 가격 정보를 얻기까지 대기하는 것이 아니라 각 상점에서 가격 정보를 얻을 때마다 즉시
	 *  최저 가격을 찾고 데이터를 갱신한다.
	 *  
	 * 블록 호출 Blocking Call
	 * 호출자와 피호출자가 다른 스레드에서 실행되더라도 동작을 완료를 기다리는 것
	 * 
	 * 비 블록 호출 Non-Blockig Call
	 * 메서드의 결과가 즉시 반환 되고 끝내지 못한 나머지 작업을 호출자 스레드와 동기적으로 
	 * 실행될 수 있도록 다른 스레드에 할당한다.
	 * 결과를 콜백 메소드를 호출해서 전달한다.
	 * 
	 */
	
	@Test
	public void asyncAPIUsingShop() {
		Shop shop = new Shop("BestShop");
		long start = System.nanoTime();
		Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
		long invocationTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Invocation returned after " + invocationTime + " msecs");
		
		// 제품 가격을 계산하는 동한 다른 상점 검색 등 다른 작업 수행
		//doSomeThingElse();
		
		try {
			double price = futurePrice.get();
			System.out.printf("Price is %.2f%n", price);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Price returned after " + retrievalTime + " msecs");
		
	}
}
