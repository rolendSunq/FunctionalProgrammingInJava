package chapter3.part20.current_sub_directory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListDirs {
	public static void main(String[] args) {
		// 현재 디렉터리에 있는 서브 디렉터리를 찾고자 한다면 filter()메서드를 사용한다.
		// Files 클래스에 isDirectory() 메서드를 이용하면 되며 이 메소드는 boolean을 리턴한다.
		// 출력의 내용은 현재 디렉터리내의 서브디렉터리 목록을 보여준다.
		try {
			Files.list(Paths.get( ".")).filter(Files::isDirectory).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
