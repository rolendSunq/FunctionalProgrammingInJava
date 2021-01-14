package java8.inaction.chapter08.factory;

public class Stock extends Product {
	
	public Stock() {
		super.setProductName("stock");
	}
	
	public String getProductName() {
		return super.getProductName();
	}
	
}
