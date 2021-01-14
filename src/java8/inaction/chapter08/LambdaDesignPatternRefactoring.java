package java8.inaction.chapter08;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import java8.inaction.chapter08.chainofresponsibility.HeaderTextProcessing;
import java8.inaction.chapter08.chainofresponsibility.ProcessingObject;
import java8.inaction.chapter08.chainofresponsibility.SpellCheckerProcessing;
import java8.inaction.chapter08.factory.Bond;
import java8.inaction.chapter08.factory.Loan;
import java8.inaction.chapter08.factory.Product;
import java8.inaction.chapter08.factory.ProductFactory;
import java8.inaction.chapter08.factory.Stock;
import java8.inaction.chapter08.factory.TriFunction;
import java8.inaction.chapter08.observer.Feed;
import java8.inaction.chapter08.observer.Guardian;
import java8.inaction.chapter08.observer.LeMonde;
import java8.inaction.chapter08.observer.NYTimes;
import java8.inaction.chapter08.strategy.IsAllLowerCase;
import java8.inaction.chapter08.strategy.IsNumeric;
import java8.inaction.chapter08.strategy.Validator;
import java8.inaction.chapter08.templatemethod.Customer;
import java8.inaction.chapter08.templatemethod.OnlineBankingLambda;

public class LambdaDesignPatternRefactoring {
	public static void main(String[] args) {
		Validator numericValidator = new Validator(new IsNumeric());
		boolean b1 = numericValidator.validate("aaaa");
		Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
		boolean b2 = lowerCaseValidator.validate("bbbb");
		
		System.out.println("b1--->>> " + b1);
		System.out.println("b2--->>> " + b2);
		
		// 람다 표현식의 직접 전달 방식
		Validator numericValidatorII = new Validator((String s) -> s.matches("[a-z]+"));
		boolean b11 = numericValidatorII.validate("aaaa");
		Validator lowerCaseValidatorII = new Validator((String s) -> s.matches("\\d+"));
		boolean b22 = lowerCaseValidatorII.validate("bbbb");
		
		System.out.println("b11--->>> " + b11);
		System.out.println("b22--->>> " + b22);
		
		OnlineBankingLambda.processCustomer("1", (Customer c) ->
			System.out.println("Hello " + c.getName())
		);
		
		// Feed는 트윗을 받았을 때 알림을 보낼 옵저버 리스트를 유지한다.
		Feed f = new Feed();
		f.registerObserver(new NYTimes());
		f.registerObserver(new Guardian());
		f.registerObserver(new LeMonde());
		f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
		
		// 옵저버 람다 표현식 사용하기
		/**
		 * 옵저버 인터페이스를 구현하는 모든 클래스는 하나의 메서드 notify를 구현했다.
		 * 트윗이 도착했을 때 어떤 동작을 수행할 것인지 감싸는 코드를 구현한 것이다.
		 * 여기서 해왔던 작업들은 람다를 통해 불필요한 감싸는 코드를 제거했다.
		 * 세 개의 옵저버를 명시적으로 인스턴스화하지 않고 람다 표현식을 직접 전달해서
		 * 실행할 동작을 지정할 수 있다.
		 */
		f.registerObserver((String tweet) -> {
			if (tweet != null && tweet.contains("money")) {
				System.out.println("Breaking news in NY! " + tweet);
			}
		});
		f.registerObserver((String tweet) -> {
			if (tweet != null && tweet.contains("queen")) {
				System.out.println("Yet another news in London... " + tweet);
			}
		});
		
		// HeaderTextProcessing, SpellCheckerProcessing 의 두 작업을 객체에 연결하여 작업 체인을 만들 수 있다.
		ProcessingObject<String> p1 = new HeaderTextProcessing();
		ProcessingObject<String> p2 = new SpellCheckerProcessing();
		
		// 두 작업 처리 객체를 연결한다.
		p1.setSuccessor(p2);
		
		String result = p1.handle("Aren't labdas really sexy?!");
		System.out.println("result--->>> " + result);
		
		// 람다 표현식
		/**
		 * 많이 보던 함수 조합 패턴이 느껴진다.
		 * 작업 처리 객체를 Function<String, String>, UnaryOperator<String> 형식의 인스턴스로 표현할 수 있다.
		 * andThen 메서드로 이들 함수를 조합해서 체인을 만들 수 있다.
		 */
		// 첫 번째 작업처리 객체
		UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;
		// 두 번째 작업처리 객체
		UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");
		// 동작 체인으로 두 함수를 조합한다.
		Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
		String resultText = pipeline.apply("Aren't labdas really sexy?!!");
		System.out.println("resultText--->>> " + resultText);
		
		// 팩토리 패턴은 생성자와 설정을 외부로 노출하지 않고 클라이언트가 단순하게 상품을 생산할 수 있다.
		Product p = ProductFactory.createProduct("loan");
		System.out.println("Product--->>> " + p.getProductName());
		
		// 팩토리 패턴 람다 표현식 사용
		// 생성자에 메서드 레퍼런스처럼 접근할 수 있다.
		Supplier<Product> loanSupplier = Loan::new;
		Product pII = loanSupplier.get();
		System.out.println("Product--->>> " + pII.getProductName());
		
		// 상품명을 생성자로 연결하는 Map을 만들어서 코드를 재구현할 수 있다.
		final Map<String, Supplier<Product>> productMap = new HashMap<>();
		productMap.put("loan", Loan::new);
		productMap.put("stock", Stock::new);
		productMap.put("bond", Bond::new);
		
		productMap.forEach((k, v) -> System.out.println(k + " : " + v.get().getProductName()));
		
		// 여러 인수를 전달하는 팩토리 메서드가 있다면 위에서 사용한 방법에는 한계가 있다.
		// 여러개 인수를 전달하려는 팩토리 메서드를 사용한다면 TriFunction interface를 참고하라.
		// 결국 특별한 형태의 interface를 만들어야 한다. 그리고 메소드 시그니처가 복잡해질 것이다.
		@SuppressWarnings("unused")
		Map<String, TriFunction<Integer, Integer, String, Product>> map = new HashMap<>();	
		
	}
}
