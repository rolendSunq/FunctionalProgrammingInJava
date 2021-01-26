package java8.inaction.chapter09.part02;

/*
 * 인터페이스의 구현 클래스에 메서드를 구현하지 않을 수 있는 디폴트 메서드
 * - 인터페이스 자체에서 기본 제공 
 * 
 * 추상 클래스와 자바 8의 인터페이스
 * 1. 클래스는 하나의 추상 클래스만 상속 받을 수 있지만 인터페이스를 여러 개 구현할 수 있다.
 * 2. 추상 클래스는 인스턴스 변수(필드)로 공통 상태를 가질 수 있다. 하지만 인터페이스는 인스턴스
 * 변수를 가질 수 없다.
 * 
 */
public interface Sized {
	public int size();
	default boolean isEmpty() {
		return size() == 0;
	}
}
