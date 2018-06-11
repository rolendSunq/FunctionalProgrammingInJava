package chapter5.part04.using_arm;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterARM implements AutoCloseable {
	private final FileWriter writer;
	
	@Override
	public void close() throws Exception {
		System.out.println("close called automaticly...");
		writer.close();

	}
	
	public FileWriterARM(final String fileName) throws IOException {
		writer = new FileWriter(fileName);
	}
	
	public void writeStuff(final String message) throws IOException {
		writer.write(message);
	}
	
}
