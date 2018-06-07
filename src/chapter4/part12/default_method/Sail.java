package chapter4.part12.default_method;

public interface Sail {
	public default void cruise() { System.out.println("Sail::cruise"); }
	public default void turn() { System.out.println("Sail::turn"); }
}
