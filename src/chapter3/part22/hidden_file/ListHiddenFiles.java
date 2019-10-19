package chapter3.part22.hidden_file;

import java.io.File;

public class ListHiddenFiles {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		final File[] files = new File(".").listFiles(file -> file.isHidden());
	}
}
