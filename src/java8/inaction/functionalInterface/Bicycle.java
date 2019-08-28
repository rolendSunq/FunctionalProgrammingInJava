package java8.inaction.functionalInterface;

public class Bicycle {
	private String brand;
	private Integer frameSize;
	private String color;
	
	public Bicycle() {
		brand = "unknown";
		frameSize = 200;	
	}
	
	public Bicycle(String brand, Integer frameSize) {
		this.brand = brand;
		this.frameSize = frameSize;
		color = "";
	}
	
	public Bicycle(String brand, Integer frameSize, String color) {
		this.brand = brand;
		this.frameSize = frameSize;
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getFrameSize() {
		return frameSize;
	}

	public void setFrameSize(Integer frameSize) {
		this.frameSize = frameSize;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("Bicycle [brand=")
				.append(brand).append(", frameSize=")
				.append(frameSize).append(", color=")
				.append(color).append("]").toString();
	}
	
}
