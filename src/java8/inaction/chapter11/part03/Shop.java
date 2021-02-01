package java8.inaction.chapter11.part03;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
	private String shopName;
	
	public Shop(String shopName) {
		this.shopName = shopName;
	}

	public String getShopName() {
		return shopName;
	}

	public double getPrice(String product) {
		return calculatePrice(product);
	}
	
	/*
	 * CompletableFuture의 인스턴스 생성을 하여 활용했지만 좀 더 간단하게 
	 * CompletableFuture를 만드는 방법이 있다.
	 * CompletableFuture는 Supplier를 인수로 받아서 ComplatableFuture를 반환한다.
	 * ComplatableFuture는 Supplier를 실행해서 비동기적으로 결과를 생성한다.
	 * ForkJoinPool의 Executor 중 하나가 Supplier를 실행할 것이다.
	 * supplyAsync 메서드에 두 번째 인수를 받는 오버로드 메서드로 다른 Executor를 지정할 수 있다.
	 * 결국 모든 다른 CompletableFuture의 팩토리 메서드에 Executor를 선택적으로 전달할 수 있게 된다.
	 * 
	 */
	public Future<Double> getPriceAsync(String product) {
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
	}
	
	private double calculatePrice(String product) {
		delay();
		Random random = new Random();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}

	public static void delay() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
