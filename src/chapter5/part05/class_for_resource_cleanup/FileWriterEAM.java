package chapter5.part05.class_for_resource_cleanup;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEAM {
	private final FileWriter writer;

	public FileWriterEAM(final String fileName) throws IOException {
		writer = new FileWriter(fileName);
	}

	public void writeStuff(final String message) throws IOException {
		writer.write(message);
	}

	public void close() throws Exception {
		System.out.println("close called automaticly...");
		writer.close();

	}

	public static void use(final String fileName, final UseInstance<FileWriterEAM, IOException> block) throws Exception {
		final FileWriterEAM writerEAM = new FileWriterEAM(fileName);
		try {
			block.accept(writerEAM);
		} finally {
			writerEAM.close();
		}
	}
}
