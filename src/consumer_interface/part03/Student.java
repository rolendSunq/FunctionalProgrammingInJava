package consumer_interface.part03;

public class Student {
	private String name;
	private double gpa;

	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public final String getName() {
		return name;
	}

	public final double getGpa() {
		return gpa;
	}
	
}
