package chapter5.part03.cleanup_guarantee;

import java.io.IOException;

public class FileWriterExampleTestMain {
	public static void main(String[] args) throws IOException {
		final FileWriterExample writerExample = new FileWriterExample("peekaboo.txt");
		
		// 예외가 발생해도 리소스에 대한 클린업이 실행되는것을 보장한다.
		try {
			writerExample.writeStuff("peek-a-boo");
		} finally {
			writerExample.close();
		}
		
		// 자동 리소스 관리(ARM: automatic resource management)를 도입해야 한다.
	}
}
