package java8.inaction.chapter08.factory;

public class Loan extends Product {
	
	public Loan() {
		super.setProductName("loan");
	}
	
	public String getProductName() {
		return super.getProductName();
	}
}
