package java8.inaction.lambda;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
	public String process(BufferedReader b) throws IOException;
}
