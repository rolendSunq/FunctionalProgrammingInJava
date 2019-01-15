package chapter3.part21.select_file_directory;

import java.io.File;

public class ListSelectFiles {
	public static void main(String[] args) {
		final String[] files = new File(".").list(new java.io.FilenameFilter() {
			public boolean accept(final File dir, final String name) {
				return name.endsWith(".java");
			}
		});
		
		System.out.println(files);
	}
	
}
