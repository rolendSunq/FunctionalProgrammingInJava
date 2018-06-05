package chapter3.part24.find_subdir;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSubDirs {
	public static void listTheHardWay() {
		List<File> files = new ArrayList<>();
		
		File[] filesInCurrenDir = new File(".").listFiles();
		for (File file : filesInCurrenDir) {
			File[] filesInSubDir = file.listFiles();
			if (filesInSubDir != null) {
				files.addAll(Arrays.asList(filesInSubDir));
			} else {
				files.add(file);
			}
		}
		
		System.out.println("Count: " + files.size());
	}
	
	public static void main(String[] args) {
		listTheHardWay();
	}
}
