package chapter3.part20.select_directory;

import java.io.File;
import java.io.FilenameFilter;

public class ListSelectFiles {
	public static void main(String[] args) {
		final String[] files = new File("src").list(new FilenameFilter() {
			public boolean accept(final File dir, final String name) {
				return name.endsWith(".java");
			}
		});
		
		System.out.println(files);
	}
}
