package chapter3.part23.reduce;

import java.io.File;

public class ListHiddenFiles {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		final File[] files = new File(".").listFiles(File::isHidden);
	}
}
