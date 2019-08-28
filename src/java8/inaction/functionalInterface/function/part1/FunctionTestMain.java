package java8.inaction.functionalInterface.function.part1;

import java.util.Arrays;
import java.util.List;

public class FunctionTestMain {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("lambdas", "in", "action");
		List<Integer> lenList = ArrayOperate.map(strList, (String s) -> s.length());
		System.out.println(lenList.toString());
	}

}
