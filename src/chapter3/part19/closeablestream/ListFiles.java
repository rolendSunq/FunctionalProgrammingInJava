package chapter3.part19.closeablestream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * File 클래스의 list() 메서드를 사용하여 디렉터리의 모든 파일 이름을 리스트로 관리할 수 있다.
 * 이름 대신에 파일을 얻기 위해 listFiles() 메서드를 사용한다.
 * CloeableStream 인터페이스를 사용하며 고차원의 편의 기능 함수(high-order convenience function)
 * 를 함께 사용한다.
 */
public class ListFiles {
	public static void main(String[] args) throws IOException {
		Files.list(Paths.get(".")).forEach(System.out::println);
	}
}
