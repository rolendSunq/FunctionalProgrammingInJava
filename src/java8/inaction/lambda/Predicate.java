package java8.inaction.lambda;

@FunctionalInterface
public interface Predicate<T> {
	public boolean test(T t);
}
