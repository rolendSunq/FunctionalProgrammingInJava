package java8.inaction.chapter13.part02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class FunctionalPractice {
	public static List<List<Integer>> subsets(List<Integer> list) {
		
		if (list.isEmpty()) {
			List<List<Integer>> ans = new ArrayList<>();
			ans.add(Collections.emptyList());
			return ans;
		}
		
		Integer first = list.get(0);
		List<Integer> rest = list.subList(1, list.size());
		
		List<List<Integer>> subans = subsets(rest);
		List<List<Integer>> subans2 = insertAll(first, subans);
		
		return concat(subans, subans2);
	}
	
	private static List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b) {
		List<List<Integer>> r = new ArrayList<>(a);
		r.addAll(b);
		return r;
	}
	
	private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
		List<List<Integer>> result = new ArrayList<>();
		
		for (List<Integer> list : lists) {
			List<Integer> copyList = new ArrayList<>();
			copyList.add(first);
			copyList.addAll(list);
			result.add(copyList);
		}
		
		return result;
	}
	
	@Test
	public void subSetTest() {
		List<Integer> mySets = Arrays.asList(1, 4, 9);
		List<List<Integer>> resultList = subsets(mySets);
		System.out.println("result List: " + resultList);
	}
}
