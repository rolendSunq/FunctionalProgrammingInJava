package java8.inaction.chapter09.part04;

public interface A {
	default void hello() {
		System.out.println("Hello Form A");
	}
}
