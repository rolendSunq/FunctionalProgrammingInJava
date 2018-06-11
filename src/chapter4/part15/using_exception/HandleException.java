package chapter4.part15.using_exception;

import java.io.IOException;
import java.util.stream.Stream;

public class HandleException {
	public static void main(String[] args) {
		/*
		Stream.of("/user", "/tmp")
		.map(path -> {
				try {
					return new File(path).getCanonicalPath();
				} catch(IOException ex) {
					return ex.getMessage();
				}
			}).forEach(System.out::println);
		*/
	}
}
