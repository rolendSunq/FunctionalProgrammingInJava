package java8.inaction.lambda;

import java.util.ArrayList;
import java.util.List;

public class PredicateFilter {

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> resultList = new ArrayList<>();
		for (T s : resultList) {
			if (p.test(s)) {
				resultList.add(s);
			}
		}
		
		return resultList;
	}
}
