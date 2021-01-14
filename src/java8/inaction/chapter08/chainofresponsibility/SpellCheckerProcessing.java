package java8.inaction.chapter08.chainofresponsibility;

public class SpellCheckerProcessing extends ProcessingObject<String> {

	@Override
	protected String handleWork(String text) {
		return text.replace("labda", "lambda");
	}

}
