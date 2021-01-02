package java8.inaction.stream.chapter6;

public class CollectorHarness {

	public static void main(String[] args) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			PrimeNumbersCollector.partitionPrimes(1_000_000);
			long duration = (System.nanoTime() - start) / 1_000_000;
			if (duration < fastest) {
				fastest = duration;
			}
		}
		System.out.println("Fastest excution done in " + fastest + " msecs");
	}

}
