package java8.inaction.chapter11.part09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

import org.junit.Test;

import java8.inaction.chapter11.part08.ExchangeService;
import java8.inaction.chapter11.part08.ExchangeService.Money;
import java8.inaction.chapter11.part08.Shop;

public class Version7FutureUsingTest {
	@Test
	public void priceCollect() {
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
				new Shop("LetsSaveBig"),
				new Shop("MyFavoriteShop"),
				new Shop("BuyItAll"));
		long start = System.nanoTime();
		System.out.println(findPriceInUSDJava7(shops, "myPhone27S"));
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + " msecs");
	}

	public List<String> findPriceInUSDJava7(List<Shop> shops, String product) {
		ExecutorService executor = getExecutor(shops);
		List<Future<Double>> priceFutures = new ArrayList<>();
		
		for (Shop shop : shops) {
			final Future<Double> futureRate = executor.submit(new Callable<Double>() {

				@Override
				public Double call() throws Exception {
					return ExchangeService.getRate(Money.EUR, Money.USD);
				}
				
			});
			Future<Double> futurePriceInUSD = executor.submit(new Callable<Double>() {

				@Override
				public Double call() throws Exception {
					try {
						double priceInEUR = shop.getPrice(product);
						return priceInEUR * futureRate.get();
					} catch(InterruptedException | ExecutionException e) {
						throw new RuntimeException(e.getMessage(), e);
					}
				}
			});
			priceFutures.add(futurePriceInUSD);
		}
		
		List<String> prices = new ArrayList<>();
		
		for(Future<Double> priceFuture : priceFutures) {
			try {
				prices.add(/* shop.getName() + */ " price is " + priceFuture.get());
			} catch (ExecutionException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return prices;
	}
	
	public List<String> findPriceInUSD(List<Shop> shops, String product) {
		List<CompletableFuture<Double>> priceFutures = new ArrayList<>();
		
		for (Shop shop : shops) {
			CompletableFuture<Double> futurePriceInUSD = 
					// 제품가격 정보를 요청하는 첫 번째 태스크를 생성한다.
					CompletableFuture.supplyAsync(() -> shop.getPrice(product))
					.thenCombine(
							CompletableFuture.supplyAsync(
									// USD, EUR 의 환율 정보를 요청하는 독립적인 두 번째 태스크를 생성한다.
									() -> ExchangeService.getRate(ExchangeService.Money.EUR, ExchangeService.Money.USD)),
							// 두 결과를 곱해서 가격과 환율 정보를 합친다.
							(price, rate) -> Double.valueOf(price) * rate
					);
			priceFutures.add(futurePriceInUSD);
		}
		
		List<String> prices = priceFutures
				.stream()
				.map(CompletableFuture::join)
				.map(price -> " price is " + price)
				.collect(Collectors.toList());
		
		return prices;
	}
	
	private ExecutorService getExecutor(List<Shop> shops) {
		final ExecutorService executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setDaemon(true);
				return t;
			}
			
		});
		
		return executor;
	}
	
}
