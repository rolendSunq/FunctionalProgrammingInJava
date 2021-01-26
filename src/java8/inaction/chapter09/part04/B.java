package java8.inaction.chapter09.part04;

public interface B extends A {
	default void hello() {
		System.out.println("Hello From B");
	}
}
