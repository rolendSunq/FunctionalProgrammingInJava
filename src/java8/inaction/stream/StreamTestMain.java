package java8.inaction.stream;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// double[] 배열 스트림 피타고린트리플2 
		// 2 ~ 99의 숫자 생성
		// 2 ~ 99의 다음 수 생성
		// double 배열 (a, b, a*a + b*b) 생성
		// filter index 2의 배열이 1로 나누어 나머지가 0인 인자 추출
		Stream<double[]> pythagoreanTriple = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100).mapToObj(b -> new double[] {a, b, Math.sqrt(a * a + b * b)})
				.filter(t -> t[2] % 1 == 0));
		
		pythagoreanTriple.forEachOrdered(n -> {for (double e : n) {
				System.out.println(e);
			}
		});
		
		Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
		
		Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]}).limit(20)
			.forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
		
		// generate
		Stream.generate(Math::random).limit(5).forEach(System.out::println);
		
		IntStream twos = IntStream.generate(new IntSupplier() {
			public int getAsInt() {
				return 2;
			}
		});
		
		IntStream ones = IntStream.generate(() -> 1);
		
		IntStream twos2 = IntStream.generate(new IntSupplier() {
			public int getAsInt() {
				return 2;
			}
		});
		
		IntSupplier fib = new IntSupplier() {
			private int previous = 0;
			private int current = 1;
			public int getAsInt() {
				int oldPrevious = 0;
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return oldPrevious;
			}
		};
		
		IntStream.generate(fib).limit(10).forEach(System.out::println);
	}
}
