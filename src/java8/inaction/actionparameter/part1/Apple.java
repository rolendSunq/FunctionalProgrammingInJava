package java8.inaction.actionparameter.part1;

public class Apple {
	private String color;
	
	public Apple(String color) {
		this.color = color;
		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("Apple [color=").append(color).append("]").toString();
	}
	
	
}
