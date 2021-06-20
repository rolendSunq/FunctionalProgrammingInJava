package currying.part02;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class LetterCurryingUsing {
	@Test
	public void letterCreateTest() {
		Letter lt = Letter.simpleCurriedLetterCreater().apply("Hello World").apply(" Hi Everybody");
		System.out.println(lt);
	}
	
	@Test
	public void whenSimpleLetterCreator() {
		Letter lt = Letter.simpleCurriedLetterCreater().apply("SALUTATION").apply("BODY");
		assertNotEquals(lt, Letter.SIMPLE_LETTER_CREATOR.apply("SALUTATION", "BODY"));
	}
}
