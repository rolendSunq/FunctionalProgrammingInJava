package chapter3.part21.using_lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListSelectFiles {
	public static void main(String[] args) throws IOException {
		Files.newDirectoryStream(Paths.get("src/chapter3/part21/using_lambda"), path -> path.toString().endsWith(".java"))
		.forEach(System.out::println);
	}
}
