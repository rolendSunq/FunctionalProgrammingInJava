package java8.inaction.stream;

/**
 * @author Administrator
 *
 */
public class Dish {
	private String name;
	private boolean vegiterian;
	private int calories;
	private Type type;
	
	public Dish(String name, boolean vegiterian, int calories, Type type) {
		this.name = name;
		this.vegiterian = vegiterian;
		this.calories = calories;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVegiterian() {
		return vegiterian;
	}

	public void setVegiterian(boolean vegiterian) {
		this.vegiterian = vegiterian;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public enum Type {
		MEAT, FISH, OTHER
	}

	@Override
	public String toString() {
		return new StringBuffer().append("Dish [name=").append(name)
				.append(", vegiterian=").append(vegiterian)
				.append(", calories=").append(calories)
				.append(", type=").append(type).append("]")
				.toString();
	}
	
	
}
