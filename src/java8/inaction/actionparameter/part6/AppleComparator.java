package java8.inaction.actionparameter.part6;

import java8.inaction.actionparameter.part5.Apple;

public class AppleComparator implements Comparator<Apple> {

	@Override
	public int compare(Apple o1, Apple o2) {
		Integer a1Weight = new Integer(o1.getWeight());
		return a1Weight.compareTo(o2.getWeight());
	}

}
