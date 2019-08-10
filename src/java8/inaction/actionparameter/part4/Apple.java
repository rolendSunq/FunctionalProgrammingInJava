package java8.inaction.actionparameter.part4;

public class Apple {
	private String color;
	private int weight;
	private Boolean flag;
	
	public Apple(String color, int weight, Boolean flag) {
		this.color = color;
		this.weight = weight;
		this.flag = flag;
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

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("Apple [color=").append(color)
				.append(", weight=").append(weight)
				.append(", flag=").append(flag)
				.append("]").toString();
	}
	
	
}
