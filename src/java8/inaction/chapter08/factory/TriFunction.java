package java8.inaction.chapter08.factory;

public interface TriFunction<T, U, V, R> {
	R apply(T t, U u, V v);
}
