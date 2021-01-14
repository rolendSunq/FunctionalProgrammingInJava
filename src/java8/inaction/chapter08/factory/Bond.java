package java8.inaction.chapter08.factory;

public class Bond extends Product {
	
	public Bond() {
		super.setProductName("bond");
	}
	
	public String getProductName() {
		return super.getProductName();
	}
	
}
