package java8.inaction.functionalInterface.consumer.part4;

public class Student {
	private String name;
	private Double gpa;
	
	public Student(String name, Double gpa) {
		this.name = name;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("Student [name=").append(name).append(", gpa=").append(gpa).append("]").toString();
	}
	
	
}
