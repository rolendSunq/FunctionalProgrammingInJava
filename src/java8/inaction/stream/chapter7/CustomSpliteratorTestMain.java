package java8.inaction.stream.chapter7;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CustomSpliteratorTestMain {

	public static void main(String[] args) {
		final String SENTENCE = " Nel  mezzo del cammin  di nostra  vita " +
			"mi  ritrovai in una  selva oscura" +
			" ch  la  dritta via era  smarrita ";
		System.out.println("Found " + countWordsIteratively(SENTENCE) + " words");
		// 함수형으로 단어 개수 계산 메서드 재구현하기
		Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
		
		// WordCounterSpliterator를 병렬 스트림에 사용
		Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
		Stream<Character> parallelStream = StreamSupport.stream(spliterator, true);
		System.out.println("Found " + countWordsIteratively(SENTENCE) + " words");
		
	}
	
	public static int countWordsIteratively(String s) {
		int counter = 0;
		boolean lastSpace = true;
		for (char c : s.toCharArray()) {
			if (Character.isWhitespace(c)) {
				lastSpace = true;
			} else {
				if (lastSpace) {
					counter++;
				}
				lastSpace = false;
			}
		}
		return counter;
	}

}
