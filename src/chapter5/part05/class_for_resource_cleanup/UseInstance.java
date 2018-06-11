package chapter5.part05.class_for_resource_cleanup;

@FunctionalInterface
public interface UseInstance<T, X extends Throwable> {
	public void accept(T instance) throws X;
}
