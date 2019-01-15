package chapter3.value_object;

public class Person {
	private final String name;
	private final int age;
	
	public Person(final String name, final int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public int ageDifference(final Person other) {
		return age - other.age;
	}

	@Override
	public String toString() {
		return String.format("Person [name=%s, age=%d]", name, age);
	}
	
	
}
