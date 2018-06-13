package consumer_interface.part01;

import java.util.function.Consumer;

/*
 * 소비자 인터페이스는 단일 입력 인수를 받아들이고 결과를 반환하지 않는 연산을 나타냅니다.
 */
public class UsingConsumerTestMain {

	public static void main(String[] args) {
		Consumer<String> c = x -> System.out.println(x.toLowerCase());
		c.accept("Java2s.com");
	}

}
