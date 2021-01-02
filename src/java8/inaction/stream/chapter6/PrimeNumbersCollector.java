package java8.inaction.stream.chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Collector.Characteristics;

public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {
	@SuppressWarnings("serial")
	public Supplier<Map<Boolean, List<Integer>>> supplier() {
		return () -> new HashMap<Boolean, List<Integer>>() {{
			put(true, new ArrayList<Integer>());
			put(false, new ArrayList<Integer>());
		}};
	}
	
	public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
		return (Map<Boolean, List<Integer>> acc, Integer cadidate) -> {
			acc.get(isPrime(acc.get(true), cadidate)).add(cadidate);
		};
	}

	
	public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
		return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
			map1.get(true).addAll(map2.get(true));
			map1.get(false).addAll(map2.get(false));
			return map1;
		};
	}
	
	public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
		return Function.identity();
	}
	
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
	}
	
	public static Boolean isPrime(int candidate) {
		return IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);
	}
	
	// 자신의 제곱근보다 작은 소수만 찾도록 최적화한다.
	public static Boolean isPrime(List<Integer> primes, int cadidate) {
		int cadidateRoot = (int) Math.sqrt((double) cadidate);
		return takeWhile(primes, i -> i <= cadidateRoot).stream().noneMatch(p ->cadidate % p == 0);
	}
	
	// 소수 리스트와 대상 숫자의 범위가 크면 성능 문제가 발생할 수 있다.
	// 대상의 제곱보다 큰 소수를 찾으면 검사를 중단함으로 성능 문제를 개선할 수 있다.
	// 정렬된 리스트와 프레디케이트를 인수로 받아 리스트의 첫 요소에서 시작해서 프레디케이트를
	// 만족하는 가장 긴 요소로 이루어진 리스트를 반환하게 한다.
	public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
		int i = 0;
		for (A item : list) {
			// 리스트의 현재 요소가 프레디케이트를 만족하는지 검사한다.
			if (!p.test(item)) {
				// 프레디케이트를 만족하지 않으면 검사한 항목의 앞쪽에 위치한 
				// 서브리스트를 반환한다.
				return list.subList(0, i);
			}
			i++;
		}
		// 리스트의 모든 항목이 프레디케이트를 만족하므로 리스트 자체를 반환한다.
		return list;
		
	}
	
	public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
		return IntStream.rangeClosed(2, n).boxed().collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
	}
}
