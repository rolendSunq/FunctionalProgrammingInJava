package java8.inaction.functionalInterface.consumer.part4;

import java.util.Arrays;
import java.util.List;

public class StudentFilterTestMain {

	public static void main(String[] args) {
		List<Student> sList = Arrays.asList(new Student("John", 3.0), new Student("Mark", 4.0));
		
		StudentFilter.acceptAllEmployee(sList, e -> System.out.println(e.getName()));
		StudentFilter.acceptAllEmployee(sList, e -> e.setGpa(e.getGpa() * 1.5));
		StudentFilter.acceptAllEmployee(sList, e -> System.out.println(e.toString()));
		
	}

}
