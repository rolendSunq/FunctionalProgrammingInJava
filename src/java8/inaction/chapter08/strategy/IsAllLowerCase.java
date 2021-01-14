package java8.inaction.chapter08.strategy;

public class IsAllLowerCase implements ValidationStrategy {

	@Override
	public boolean execute(String s) {
		return s.matches("[a-z]+");
	}

}
