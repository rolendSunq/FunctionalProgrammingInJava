package chapter4.part12.default_method;

public interface FastFly extends Fly {
	public default void takeOff() { System.out.println("FastFly::takeOff"); }
}
