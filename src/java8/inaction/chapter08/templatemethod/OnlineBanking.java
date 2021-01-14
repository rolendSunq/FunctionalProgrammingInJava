package java8.inaction.chapter08.templatemethod;

public abstract class OnlineBanking {
	public void processCustomer(String id) {
		Customer c = new Database().getCustomerWithId(id);
		makeCustomerHappy(c);
	}
	
	abstract void makeCustomerHappy(Customer c);
}
