package java8.inaction.chapter10.part01_A;

public class House {
	private Host onwer;
	private String address;
	public House(Host onwer, String address) {
		super();
		this.onwer = onwer;
		this.address = address;
	}
	public Host getOnwer() {
		return onwer;
	}
	public void setOnwer(Host onwer) {
		this.onwer = onwer;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
