package java8.inaction.chapter10.part01_B;

import java.util.Optional;

public class Person {
	private String name;
	private int age;
	private String password;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}
	
	public Optional<Integer> getAge() {
		return Optional.ofNullable(age);
	}
	
	public Optional<String> getPassword() {
		return Optional.ofNullable(password);
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final void setAge(int age) {
		this.age = age;
	}

	public final void setPassword(String password) {
		this.password = password;
	}
	
	
}
