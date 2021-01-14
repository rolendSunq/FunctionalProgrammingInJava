package java8.inaction.chapter08.templatemethod;

import java.util.function.Consumer;

public class OnlineBankingLambda {
	public static void processCustomer(String id, Consumer<Customer> makeCustomerHappy) {
		Customer c = new Database().getCustomerWithId(id);
		makeCustomerHappy.accept(c);
	}
	
}
