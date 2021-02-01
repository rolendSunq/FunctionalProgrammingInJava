package java8.inaction.chapter11.part02;

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
	/*
	 * 동기 메서드를 비동기 메서드로 변환
	 * 기존에 동기 메소드 getPrice를 비동기 메서드로 변환하려면 이름과 반환값을 바꿔야 한다.
	 * 비동기 메서드를 만드는 방법 중 
	 * 1. 동기 메서드를 만든다.
	 * 2. 비동기 메서드로 변환한다.
	 */
	public double getPrice(String product) {
		return calculatePrice(product);
	}
	
	/*
	 * 비동기 계산의 결과를 표현할 수 있는 java.util.concurrent.Future 인터페이스를 제공한다.
	 * 이 인터페이스는 호출자 스레드가 블록되지 않고 다른 작업을 실행할 수 있다.
	 * Future는 결과값이 나오도록 진행(핸들)하며 get메서드를 통해 결과를 얻을 수 있다.
	 * getPriceAsync의 반환값은 Future로 나오며 호출자 스레드는 다를 작업을 수행할 수 있다.
	 * 
	 * 가격이 계산되는 동안 에러가 발생하면 어떻게 될까? 예외가 발생되면 해당 스레드에만 영향을 미친다.
	 * 즉, 에러가 발생해도 가격 계산은 계속되며 일의 순서가 꼬인다.
	 * 결국 클라이언트는 getPriceAsync메서드의 값이 반환될 때까지 대기하게 된다.
	 * 블록 문제를 해결하기 위해서는 타임아웃을 활용하면 좋다. 문제 발생시 블록 되지 않고
	 * TimeoutException을 받을 수 있다. 그러나 제품 가격 계산의 에러가 발생했는지 
	 * 알 수 있는 방법이 없다.
	 * 따라서 completeExceptionall 메서드를 이용하여 CompletableFuture 내부에
	 * 발생한 예외를 클라이언트에 전달한다.
	 * 
	 */
	public Future<Double> getPriceAsync(String product) {
		// 비동기 계산과 완료 결과를 포함하는 CompletableFuture 인스턴스를 만든다.
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		
		new Thread(() -> {
			try {
				// 비동기식으로 계산을 수행할 스레드를 할당하게 된다.
				double price = calculatePrice(product);
				// 지연 시간이 긴 계산이 완료(프로세스의 완료)되면 Future에 값을 설정한다.
				futurePrice.complete(price);
			} catch (Exception ex) {
				futurePrice.completeExceptionally(ex);
			}
		}).start();
		// 계산 결과가 완료될 때 까지 대기(동기화) 하지 않는다.(비동기)
		// Future를 반환한다. 이 의미는 비동기식의 관점으로 봤을때 계산 완료의 값을 매번 가지고 있지 않는다는
		// 의미이다.
		return futurePrice;
	}
	
	/*
	 * 내부에서 dalay()메서드를 호출하여 비동기 동작이 완료될 때까지 1초 동안 블록된다.
	 * 만약에 실제로 네트워크상의 모든 온라인 상점의 가격을 검색하는 상황이 블록처리 된다면
	 * 곤란할 것이다. 여러분들이 생각한 바와 같이 상당한 시간이 필요할 것이다.
	 * 하지만 방법이 없지 않다. 동기 API를 비동기로 처리하는 방법이 있다. 
	 * 그러나 지금은 비동기 API를 경험해야한다.
	 */
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
