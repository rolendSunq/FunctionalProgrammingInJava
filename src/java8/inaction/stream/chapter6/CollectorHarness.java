package java8.inaction.stream.chapter6;

public class CollectorHarness {

	// 주의 상당한 시간이 소요됨 20분 ~ 30분 정도 예상되며 시스템 사양에 따라 차이가 있음
	public static void main(String[] args) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			PrimeNumbersCollector.partitionPrimes(1_000_000);
			long duration = (System.nanoTime() - start) / 1_000_000;
			if (duration < fastest) {
				fastest = duration;
			}
			System.out.println("Loading...");
		}
		System.out.println("Fastest excution done in " + fastest + " msecs");
	}

}
