package java8.inaction.functionalInterface.methodreference.part1;

import java.util.Comparator;

import java8.inaction.functionalInterface.Bicycle;

public class BicycleComparator implements Comparator<Bicycle> {

	@Override
	public int compare(Bicycle t1, Bicycle t2) {
		return t1.getFrameSize().compareTo(t2.getFrameSize());
	}

}
