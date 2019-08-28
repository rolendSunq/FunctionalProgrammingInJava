package java8.inaction.functionalInterface.consumer.part4;

import java.util.List;
import java.util.function.Consumer;

public class StudentFilter {
	public static void acceptAllEmployee(List<Student> student, Consumer<Student> printer) {
		for (Student s : student) {
			printer.accept(s);
		}
	}
}
