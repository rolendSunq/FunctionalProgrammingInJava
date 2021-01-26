package java8.inaction.chapter09.part03;

public interface Rotatable {
	public void setRotationAngle(int angleInDegress);
	public int getRotationAngle();
	default void rotateBy(int angleInDegress) {
		setRotationAngle((getRotationAngle () + angleInDegress) % 360);
	}
}
