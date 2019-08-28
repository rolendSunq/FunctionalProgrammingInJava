package java8.inaction.functionalInterface.function.part1;

@FunctionalInterface
public interface Function<T, R> {
	public R apply(T t);
}
