package chapter4.part12.default_method;

public class SeaPlane extends Vehicle implements FastFly, Sail {
	private int altitude;
	
	public void cruise() {
		System.out.println("SeaPlane::cruise currently cruise like: ");
		if (altitude > 0) {
			FastFly.super.cruise();
		} else {
			Sail.super.cruise();
		}
	}
}
