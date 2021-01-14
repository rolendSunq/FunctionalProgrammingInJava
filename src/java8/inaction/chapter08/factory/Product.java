package java8.inaction.chapter08.factory;

public class Product {
	private final String productInfo = "Gold_Capital_Group";
	private String productName;

	public final String getProductInfo() {
		return productInfo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
