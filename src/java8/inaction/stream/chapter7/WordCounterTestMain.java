package java8.inaction.stream.chapter7;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WordCounterTestMain {

	public static void main(String[] args) {
		final String SENTENCE = "Among Langdon's personal belongings, Langdon and Brooks find a Faraday pointer, a miniature image projector with a modified version of Sandro Botticelli's Map of Hell, which itself is based on Dante's Inferno. They soon realize this is the first clue in a trail left by Bertrand Zobrist, a dangerously unstable villain who believed that rigorous measures were necessary to reduce the Earth's growing population, and who committed suicide three days earlier after being chased by armed government agents.";
		Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
		//System.out.println("Found " + countWords(stream) + " words");
		System.out.println("Found " + countWords(stream.parallel()) + " words");
	}
	
	public static int countWords(Stream<Character> stream) {
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
		return wordCounter.getCounter();
	}

}
