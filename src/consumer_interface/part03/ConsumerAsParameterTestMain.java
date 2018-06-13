package consumer_interface.part03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerAsParameterTestMain {
	private static void acceptAllEmployee(List<Student> students, Consumer<Student> printer) {
		for (Student e : students) {
			printer.accept(e);
		}
	}
	
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("John", 3), 
				new Student("Mark", 4));
		
		acceptAllEmployee(students, e -> System.out.println(e.getName()));
		acceptAllEmployee(students, e -> {
			e.setGpa(e.getGpa() * 1.5);
		});
		acceptAllEmployee(students, e -> System.out.println(e.getName() + " : " + e.getGpa()));
	}

}
