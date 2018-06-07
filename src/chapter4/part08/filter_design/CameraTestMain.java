package chapter4.part08.filter_design;

import java.awt.Color;
import java.util.function.Consumer;

import chapter4.Camera;

public class CameraTestMain {

	public static void main(String[] args) {
		final Camera camera = new Camera();
		final Consumer<String> printCaptured = 
				(filterInfo) -> System.out.println(
						String.format("with %s: %s", filterInfo, camera.capture(new Color(200, 100, 200))));
		printCaptured.accept("no filter");
	}

}
