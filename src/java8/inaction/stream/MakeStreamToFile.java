package java8.inaction.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class MakeStreamToFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long uniqueWords = 0;
		try (Stream<String> lines = 
				Files.lines(Paths.get("D:\\myGit\\FunctionalProgrammingInJava\\src\\java8\\inaction\\stream\\data.txt "), Charset.defaultCharset())) {
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split("<")))
						.distinct()
						.count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("uniqueWords: " + uniqueWords);
	}

}
