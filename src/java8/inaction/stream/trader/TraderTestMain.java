package java8.inaction.stream.trader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TraderTestMain {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
		
		List<Transaction> traderList = transactions.stream()
				.filter(a -> a.getYear() == 2011)
				.collect(Collectors.toList());
		
		System.out.println("2011년에 일어난 모든 트랜잭션 ===> " + traderList);
	}

}
