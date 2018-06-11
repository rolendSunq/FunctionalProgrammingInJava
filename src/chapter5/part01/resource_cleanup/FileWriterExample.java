package chapter5.part01.resource_cleanup;

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
	
	public void finalize() throws IOException {
		// TODO: resource Clean up
		
		// 파일 내용을 flush하고 종료 
		writer.close();
		
		System.out.println("finalize() 실행");
	}
	
}
