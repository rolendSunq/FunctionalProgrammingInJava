package java8.inaction.chapter09.part01;

public interface Resizable {
	public int getWidth();
	public int getHeight();
	public void setWidth(int width);
	public void setHeight(int height);
	public void setAbsoluteSize(int width, int height);
	/*
	 * 새로운 메서드 추가가 있을 경우  Resizable을 구현한 모든 클래스는 
	 * setRelativeSize 메서드를 구현해야 한다.
	 * 구현 클래스에서 setRelativeSize 메서드를 구현하지 않아도 바이러니 호환성은 유지된다.
	 * - 바이러니 호환성: 새로 추가된 메서드를 호출하지 않으면 새로운 메서드 구현 없이 기존
	 * 클래스 파일은 잘 동작한다.
	 * 하지만 언젠가는 누군가가 Resizable을 인수로 받는 Utils.paint에서 setRelativeSize를
	 * 사용하도록 코드를 바꿀 수 있다. 이때 Ellipse 객체가 인수로 전달되면 Ellipse는 
	 * setRelativeSize 메서드를 정의하지 않았으므로 런타임에 에러가 발생한다.
	 * Eillipse를 포함한 전체 애플리케이션을 재빌드할 때 컴파일 에러가 발생한다.
	 * 
	 */
	// 새로운 메서드
	//public void setRelativeSize(int wFactor, int hFactor);
	default void setRelativeSize(int wFactor, int hFactor) {
		setAbsoluteSize(getWidth() / wFactor, getHeight() / hFactor);
	}
}
