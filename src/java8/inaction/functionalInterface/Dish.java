package java8.inaction.functionalInterface;

public class Dish {
	private String name;
	private int calories;
	private String type;
	
	public Dish() {
		name = "unknown";
		calories = 0;
		type = "no type";
	}
	
	public Dish(String name, int calories) {
		this.name = name;
		this.calories = calories;
		type = "no type";
	}

	public Dish(String name, int calories, String type) {
		super();
		this.name = name;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("Dish [name=").append(name)
				.append(", calories=").append(calories)
				.append(", type=").append(type)
				.append("]").toString();
	}
	
}
