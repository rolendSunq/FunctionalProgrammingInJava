package chapter5.part03.cleanup_guarantee;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
	private final FileWriter writer;
	
	public FileWriterExample(final String fileName) throws IOException {
		// FileWriter 인스턴스 초기화
		writer = new FileWriter(fileName);
	}
	
	public void writeStuff(final String messge) throws IOException {
		writer.write(messge);
	}
	
	public void close() throws IOException {
		
		// 예외가 발생하면  close()메소드를 호출할 수 없다.
		// TODO: close() 호울을 보장해야 한다. 
		writer.close();
	}
}
