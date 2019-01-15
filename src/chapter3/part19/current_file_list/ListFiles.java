package chapter3.part19.current_file_list;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFiles {
	public static void main(String[] args) {
		
		// 현재 디렉터리를 나타내는 "." 대신 원하는 디렉터리 전체 패스로 바꿔도 된다.
		try {
			Files.list(Paths.get(".")).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
