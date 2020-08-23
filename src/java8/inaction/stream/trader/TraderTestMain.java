package java8.inaction.stream.trader;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
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
				.sorted(Comparator.comparing(Transaction::getValue))
				.collect(Collectors.toList());
		
		System.out.println("2011년에 일어난 모든 트랜잭션 ===> " + traderList);
		
		List<String> traderCityList = transactions.stream()
				.map(b -> b.getTrader().getCity())
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println("거래자가 근무하는 모든 도시 ===> " + traderCityList);
		
		List<Trader> traderFromCambrigeList = transactions.stream()
				.map(b -> b.getTrader())
				.filter(a -> a.getCity().equals("Cambridge"))
				.distinct()
				.sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList());
		
		System.out.println("Cambridge에 근무하는 모든 거래자 ===> " + traderFromCambrigeList);
		
		String traderStr = transactions.stream()
				.map(a -> a.getTrader().getName())
				.distinct()
				.sorted()
				.collect(Collectors.joining());
		
		System.out.println("모든 거래자의 이름 ===> " + traderStr);
		
		boolean isMilanTrade = transactions.stream().anyMatch(a -> a.getTrader().getCity().equals("Milan"));
		System.out.println("밀라노에 거래자가 있는가? ===> " + isMilanTrade);
		
		System.out.println("Cambridge에 거주하는 거주하는 모든 트랜잭션 값 ==> ");
		transactions.stream()
				.filter(a -> a.getTrader().getCity().equals("Cambridge"))
				.mapToInt(Transaction::getValue)
				.forEach(System.out::println);
		
		
		OptionalInt maxAllTrade = transactions.stream()
				.mapToInt(Transaction::getValue)
				.max();
		
		System.out.println("전체 트랜잭션 중 최댓값 ===> " + maxAllTrade);
		
		OptionalInt minAllTrade = transactions.stream()
				.mapToInt(Transaction::getValue)
				.min();
		
		System.out.println("전체 트랜잭션 중 최솟값 ===> " + minAllTrade);
		
	}

}
