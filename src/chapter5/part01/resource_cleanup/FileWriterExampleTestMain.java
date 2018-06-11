package chapter5.part01.resource_cleanup;

import java.io.IOException;

public class FileWriterExampleTestMain {
	public static void main(String[] args) throws IOException {
		final FileWriterExample writerExample = new FileWriterExample("peekaboo.txt");
		// peekaboo.txt 파일 생성후 메세지 작성에서 파일만 생성되고 메세지는 작성되지 않는다.
		// JVM은 충분한 메모리가 있다면 파이널라이저가 필요 없다고 생각하여 파이널라이즈 메소드를 실행하지 않는다.
		writerExample.writeStuff("peek-a-boo");
		
		// 이 문제는 명시적으로 close() 메서드를 호출하도록 해야 하며 finalize() 메서드를 제거해야 한다.
	}
}
