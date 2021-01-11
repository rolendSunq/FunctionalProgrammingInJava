package java8.inaction.stream.chapter7;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStream {

	public static void main(String[] args) {
		long sum = parallelSum(10L);
		System.out.println("sum--->>> " + sum);
		
		System.out.println("Sequential sum done in: " + measureSumPerf(ParallelStream::sequentialSum, 10_000_000) + " msecs");
		System.out.println("Sequential sum done in: " + measureSumPerf(ParallelStream::iterativeSum, 10_000_000) + " msecs");
		System.out.println("Sequential sum done in: " + measureSumPerf(ParallelStream::parallelSum, 10_000_000) + " msecs");
		System.out.println("Sequential sum done in: " + measureSumPerf(ParallelStream::rangedSum , 10_000_000) + " msecs");
		System.out.println("Parallel range sum done in: " + measureSumPerf(ParallelStream::parallelRangedSum , 10_000_000) + " msecs");
		System.out.println("SideEffect parallel sum done in: " + measureSumPerf(ParallelStream::sideEffectSum , 10_000_000) + " msecs");
	}
	
	public static long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
	}
	
	// classical java type
	public static long iterativeSum(long n) {
		long result = 0;
		for (long i = 1L; i <= n; i++) {
			result += 1;
		}
		return result;
	}
	
	public static long parallelSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
	}
	
	public static long measureSumPerf(Function<Long, Long> adder, long n) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start) / 1_000_000;
			System.out.println("Result: " + sum);
			if (duration < fastest) fastest = duration;
		}
		return fastest;
	}
	
	public static long rangedSum(long n) {
		return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
	}
	
	public static long parallelRangedSum(long n) {
		return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
	}
	
	public static long sideEffectSum(long n) {
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
		return accumulator.total;
	}
}
