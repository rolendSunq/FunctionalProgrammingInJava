package java8.inaction.actionparameter.part2;

public class Apple {
	private String color;
	private int weight;
	
	public Apple(String color, int weight) {
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("Apple [color=").append(color)
				.append(", weight=").append(weight).append("]").toString();
	}
	
	
}
