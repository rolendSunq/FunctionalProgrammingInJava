package chapter4.part12.default_method;

public interface Fly {
	public default void takeOff() { System.out.println("Fly::takeOff"); }
	public default void land() { System.out.println("Fly::land"); }
	public default void turn() { System.out.println("Fly::turn"); }
	public default void cruise() { System.out.println("Fly::cruise"); }
}
