package java8.inaction.functionalInterface.consumer.part1;

@FunctionalInterface
public interface Consumer<T> {
	public void accept(T t);
}
