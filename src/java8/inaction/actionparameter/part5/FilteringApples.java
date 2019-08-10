package java8.inaction.actionparameter.part5;

import java.util.ArrayList;
import java.util.List;

public class FilteringApples {
	
	public static <T> List<T> filter(List<T> list, ApplePredicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T e : list) {
			if (p.test(e)) {
				result.add(e);
			}
		}
		
		return result;
		
	}
}
