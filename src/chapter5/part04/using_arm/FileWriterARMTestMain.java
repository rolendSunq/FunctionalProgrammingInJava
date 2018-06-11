package chapter5.part04.using_arm;

public class FileWriterARMTestMain {
	public static void main(String[] args) throws Exception {
		// 자동 리소스 관리(ARM: automatic resource management)가 적용된 인스턴스를 생성.
		final FileWriterARM writerARM = new FileWriterARM("peekaboo.txt");
		System.out.println("done with the resource...");

		try {
			writerARM.writeStuff("peek-a-boo");
		} finally {
			writerARM.close();
		}
		
	}
}
