package chapter4.part10.filter_add2;

import java.awt.Color;
import java.util.function.Consumer;

import chapter4.Camera;

public class CameraTestMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		final Camera camera = new Camera();

		// 필터 추가는 setFilters() 메서드에 간단한 람다 표현식이거나 메서드 레퍼런스를 인자로 전달한다.
		camera.setFilters(Color::darker);

		final Consumer<String> printCaptured = (filterInfo) -> System.out.println(String.format("with %s: %s", filterInfo, camera.capture(new Color(200, 100, 200))));
		printCaptured.accept("darker filter");
	}

}
