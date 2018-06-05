package chapter3.part25.using_flatmap;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListSubDirs {
	public static void betterWay() {
		List<File> files = Stream.of(new File(".").listFiles())
				.flatMap(file -> file.listFiles() == null ? Stream.of(file) : Stream.of(file.listFiles()))
				.collect(Collectors.toList());
		
		System.out.println("Count: " + files.size());
	}
	
	public static void main(String[] args) {
		betterWay();
	}
}
