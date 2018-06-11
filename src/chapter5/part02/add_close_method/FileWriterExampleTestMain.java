package chapter5.part02.add_close_method;

import java.io.IOException;

public class FileWriterExampleTestMain {
	public static void main(String[] args) throws IOException {
		final FileWriterExample writerExample = new FileWriterExample("peekaboo.txt");
		writerExample.writeStuff("peek-a-boo");
		// 명시적으로 close() 메소드 호출
		writerExample.close();
	}
}
