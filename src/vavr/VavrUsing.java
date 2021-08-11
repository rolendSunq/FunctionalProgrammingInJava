package vavr;

import static javaslang.API.$;
import static javaslang.API.Case;
import static javaslang.API.Match;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.Test;

import chapter3.part18.grouping.Person;
import io.vavr.Function0;
import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Function5;
import io.vavr.Lazy;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import io.vavr.collection.Seq;
import io.vavr.control.Option;
import io.vavr.control.Try;
import io.vavr.control.Validation;

public class VavrUsing {
	/*
	 * Option 의 주요 목표는 코드에서 null 검사를 제거하는데 있다.
	 * Optional과 유사하며 Vavr의 객체 컨테이너이다.
	 * Vavr 의 Option은 Serializable Iterable을 구현하고 더 풍부한 API 를 가지고 있다.
	 * 
	 * 모든 객체 (대부분 참조 주소를 가지고 있다)는 null 값을 가질 수 있고 
	 * 일반적으로 if문으로 null여부를 확인 해야한다. 이 과정으로 코드를 강력하고 안정적으로 만든다.
	 * 
	 */
	@Test
	public void givenValue_whenNullCheckNeeded_thenCorrect() {
		Object possibleNullObj = null;
		
		if (possibleNullObj == null) {
			possibleNullObj = "someDefaultValue";
		}
		
		assertNotNull(possibleNullObj);
	}
	
	// 확인하지 않으면 간단한 NPE로 인해 중단 될 수 있다.
	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void givenValue_whenNullCheckNeeded_thenCorrect2() {
		Object possibleNullObj = null;
		assertEquals("somevalue", possibleNullObj.toString());
	}
	
	/*
	 * null 검사는 특히 if 문이 여러개 중첩되는 경우 코드를 장황하게 만들며
	 * 읽기 어럽게 만든다.
	 * Option은 null 을 완전히 제거하고 가능한 각 상황에 대해 유효한 개체 참조로 
	 * 대체 하여 문제를 해결한다.
	 * of(null) 은 null 값에 대한 Option 의 인스턴스로 생성한다.
	 */
	@Test
	public void givenValue_whenCreatesOption_thenCorrect() {
		Option<Object> noneOption = Option.of(null);
		Option<Object> someOption = Option.of("val");
		
		assertEquals("None", noneOption.toString());
		assertEquals("Some(val)", someOption.toString());
	}
	
	/*
	 * 객체의 값을 직접 사용하는 것 보다 Option 인스턴스에 래핑하는 것이 좋다.
	 * 이전에 toString 을 호출하기 전에 NullPointerException 을 처리할 필요가 있었지만
	 * Option 의 toString 을 호출하게 되면 값을 반환하게 한다.
	 * 
	 * 이전에서 변수에 기본값을 할당하는 null 검사가 필요했지만 Option 은 null 이 있더라도 한 
	 * 줄로 처리 할 수 있다.
	 */
	@Test
	public void givenNull_whenCreatesOption_thenCorrect() {
		String name = null;
		Option<String> nameOption = Option.of(name);
		
		assertEquals("baeldung", nameOption.getOrElse("baeldung"));
	}
	
	// null 이 아닌 경우
	@Test
	public void givenNonNull_whenCreatesOption_thenCorrect() {
		String name = "baeldung";
		Option<String> nameOption = Option.of(name);
		
		System.out.println("nameOption: " + nameOption.get());
		
		assertEquals("baeldung", nameOption.getOrElse("notbaeldung"));
	}
	
	/*
	 * 튜플 Tuple
	 * 
	 * tuple 는 변경 불가능하며 안전한 유형 방식으로 서로 다른 유형의 여러 객체를 보유 할 수 있다.
	 * Java 8 에서 튜플은 Tuple1, Tuple2... Tuple8 까지 만들 수 있으며 tuple._n 과 같이
	 * 튜플 요소에 접근할 수 있다. 여기서 n은 배열의 인덱스 개념과 유사하다.
	 * 
	 */
	@Test
	public void whenCreatesTuple_thenCorrect1() {
		Tuple2<String, Integer> java8 = Tuple.of("Java", 8);
		String element1 = java8._1;
		int element2 = java8._2();
		
		assertEquals("Java", element1);
		assertEquals(8, element2);
	}
	
	/*
	 * 첫 번째 요소는 n == 1 로 검색된다. 따라서 튜플은 배열과 같은 제로 베이스를 
	 * 사용하지 않는다. 튜플에 저장 될 요소의 type 은 선언시 type 을 명시해야 한다.
	 * 
	 * 튜플은 모든 유형(type)의 지정 된 그룹을 저장하는 것이다.  
	 */
	@Test
	public void whenCreatesTuple_thenCorrect2() {
		Tuple3<String, Integer, Double> java8  = Tuple.of("Java", 8, 1.8);
		String element1 = java8._1();
		int element2 = java8._2();
		double element3 = java8._3();
		
		assertEquals("Java", element1);
		assertEquals(8, element2);
		assertEquals(1.8, element3, 0.1);
	}
	
	/*
	 * Try
	 * 
	 * Vavr에서 Try는 예외에 대한 처리를 위한 컨테이너 이다.
	 * Option 은 입력 가능한 래핑 객체이다. 
	 * null 입력으로 try - catch 블록에 대한 예외가 필요가 없다.
	 */
	@Test(expected = ArithmeticException.class)
	public void givenBadCode_whenThrowsException_thenCorrect() {
		@SuppressWarnings("unused")
		int i = 1 / 0;
	}
	
	/*
	 * try-catch 블록이 없으면 응용 프로그램이 충돌한다. 이를 방지하려면
	 * try-catch 블록으로 래핑해야 한다.
	 * Vavr을 사용하면 Try인스턴스에 동일한 코드를 래핑하고 결과를 얻을 수 있다.
	 */
	@Test
	public void givenBadCode_whenTryHandles_thenCorrect() {
		Try<Integer> result = Try.of(() -> 1 / 0);
		
		assertTrue(result.isFailure());
	}
	
	/*
	 * 계산 성공의 여부는 코드의 자유롭게 선택하여 검사할 수 있으며
	 * 기본 값을 반환하도록 설정할 수도 있다.
	 */
	@Test
	public void givenBadCode_whenTryHandles_thenCorrect2() {
		Try<Integer> computation = Try.of(() -> 1 / 0);
		int errorSentinel = computation.getOrElse(-1);
		
		assertEquals(-1, errorSentinel);
	}
	
	/*
	 * 예외를 명시하여 던질 수 있다.
	 */
	@Test(expected = ArithmeticException.class)
	public void givenBadCode_whenTryHandless_thenCorrect3() {
		Try<Integer> result = Try.of(() -> 1 / 0);
		result.getOrElseThrow(() -> new ArithmeticException());
	}
	
	/*
	 * Functional Interface
	 * 
	 * JAVA 8 에서 Functional Interface 가 적용되어 람다와 조합하여 사용할 수 있다.
	 * 아래 예제는 단일 매개 변수로 결과를 생성한다.
	 */
	@Test
	public void givenJava8Function_whenWorks_thenCorrect() {
		Function<Integer, Integer> square = (num) -> num * num;
		int result = square.apply(2);
		
		assertEquals(4, result);
	}
	
	/*
	 * 두 개의 매개 변수로 결과를 생성한다.
	 */
	@Test
	public void givenJava8BiFunction_whenCorrect() {
		BiFunction<Integer, Integer, Integer> sum = (num1, num2) -> num1 + num2;
		int result = sum.apply(5, 7);
		
		assertEquals(12, result);
	}
	
	/*
	 * Vavr 는 최대 8개의 매개 변수를 지원하고 memoization, composition, currying 에 대한
	 * 메서드 API를 제공한다.
	 * 튜플과 같이 Functional Interface는 사용하는 매개 변수의 수에 따라 이름이 지정된다.
	 */
	@Test
	public void givenVavrFunction_whenWorks_thenCorrect() {
		Function1<Integer, Integer> square = (num) -> num * num;
		int result = square.apply(2);
		
		assertEquals(4, result);
	}
	
	@Test
	public void givenVavrBiFunction_whenWorks_thenCorrect() {
		Function2<Integer, Integer, Integer> sum = (num1, num2) -> num1 + num2;
		int result = sum.apply(5, 7);
		
		assertEquals(12, result);
	}
	
	/*
	 * 매개 변수가 없이 출력을 원하는 경우 Consumer Type을 사용해야 한다.
	 */
	@Test
	public void whenCreatesFunction_thenCorrect0() {
		Function0<String> getClazzName = () -> this.getClass().getName();
		String clazzName = getClazzName.apply();
		System.out.println("clazzName: " + clazzName);
		
		assertEquals("vavr.VavrUsing", clazzName);
	}
	
	/*
	 * 5개의 매개 변수가 사용될 땐 Function5를 사용하면 된다.
	 */
	@Test
	public void whenCreatesFunction_thenCorrect5() {
		Function5<String, String, String, String, String, String> concat = (a, b, c, d, e) -> a + b + c + d + e;
		String finalString = concat.apply("Hello ", "world", "! ", "Learn ", "Vavr");
		
		assertEquals("Hello world! Learn Vavr", finalString);
	}
	
	/*
	 * static factory FunctionN.of 메서드를 사용하기 위해 Vavr 함수에 method reference 를 결합하여
	 * 사용할 수 있다.
	 */
	public int sum(int a, int b) {
		return a + b;
	}
	
	@Test
	public void whenCraeatesFunctionFromMethodRef_thenCorrect() {
		Function2<Integer, Integer, Integer> sum = Function2.of(this::sum);
		int summed = sum.apply(5, 6);
		
		assertEquals(11, summed);
	}
	
	/*
	 * Collection
	 * 
	 * 컬렉션에 불변성을 추가 하려면 Exception 을 고려해야 한다.
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void whenImmutableCollectionThrows_thenCorrect() {
		List<String> wordList = Arrays.asList("abracadabra");
		List<String> list = Collections.unmodifiableList(wordList);
		list.add("boom"); 
	}
	
	@Test
	public void whenCreatesVavrList_thenCorrect() {
		io.vavr.collection.List<Integer> intList = io.vavr.collection.List.of(1, 2, 3);
		
		assertEquals(3, intList.length());
		assertEquals(new Integer(1), intList.get(0));
		assertEquals(new Integer(2), intList.get(1));
		assertEquals(new Integer(3), intList.get(2));
	}
	
	@Test
	public void whenSumsVavrList_thenCorrect() {
		int sum = io.vavr.collection.List.of(1, 2, 3).sum().intValue();
		
		assertEquals(6, sum);
	}
	
	/*
	 * age 에 대한 규칙은 0 보다 큰 정수이며 name은 특수 문자를 포함하지 않아야 한다.
	 */
	@Test
	public void whenValidationWorks_thenCorrect() {
		PersonValidator personValidator = new PersonValidator();
		
		Validation<Seq<String>, Person> valid = personValidator.validatePerson("John Doe", 30);
		Validation<Seq<String>, Person> invalid = personValidator.validatePerson("John? Doe!4", -1);
		
		System.out.println("valid.toString(): " + valid);
		System.out.println("invalid.toString(): " + invalid);
		
		assertEquals("Valid(Person [name=John Doe, age=30])", valid.toString());
		assertEquals("Invalid(List(Invalid characters in name?!4, Age must be at least 0))", invalid.toString());
	}
	
	/*
	 * Lazy
	 * 
	 * Lazy 는 느리게 계산 된 값을 나타내는 컨테이너이다. 결과가 필요할 때까지 계산이 지연된다.
	 * 그리고 평가 된 값은 캐시되거나 메모리에 적제되고 계산을 반복하지 않고 필요할 때 반복해서 반환된다.
	 * 
	 * Math.random 메소드를 지켜봐야한다. 두 번째 줄에서 값을 확인 하려 했을 때
	 * 함수가 아직 실행되지 않았 음을 알 수 있다.
	 * 세 번째 코드 줄에서 Lazy.get을 호출하여 계산 값을 확인한다. 이 시점에서 함수가 실행되고
	 * Lazy.evaluated 는 true 를 반환한다.
	 * 
	 * 다시 한 번 값을 얻으려 할때 Lazy 의 Memoization bit 를 확인한다. 렌덤 함수가 다시 실행된다면
	 * 다른 난수를 받게 된다.
	 * 그러나 Lazy 는 최종적으로 처음 계산 된 값을 느리게 반환한다.
	 * 
	 * 메모이제이션 (Memoization) 이란, 반복되는 동일한 계산(ex 함수 호출, 동일한 input, output의 코드 등)을 수행할 때,
	 * 처음 구해 놓은 값을 메모리에 저장해 둠으로써 동일한 반복을 제거하여 수행 속도를 높이는 기법이다.
	 */
	@Test
	public void givenFunction_whenEvaluatesWithLazy_thenCorrect() {
		Lazy<Double> lazy = Lazy.of(Math::random);
		assertFalse(lazy.isEvaluated());
		
		double val1 = lazy.get();
		System.out.println("val1: " + val1);
		assertTrue(lazy.isEvaluated());
		
		double val2 = lazy.get();
		assertEquals(val1, val2, 0.1);
	}
	
	/*
	 * 패턴 매칭
	 * 
	 * 패턴 매칭은 거의 모든 함수형 프로그래밍 언어의 기본 개념이다. 현재 Java에는 없다.
	 * 대신, 우리가 입력 받은 값에 계산을 수행하거나 값을 반환 할 때마다 여러 if 문을 
	 * 사용하여 올바른 코드를 확인하고 실행한다.
	 */
	@Test
	public void whenIfWorksAsMatcher_thenCorrect() {
		int input = 3;
		String output;
		if (input == 0) {
			output = "zero";
		}
		if (input == 1) {
			output = "one";
		}
		if (input == 2) {
			output = "two";
		}
		if (input == 3) {
			output = "three";
		} else {
			output = "unknown";
		}
		
		assertEquals("three", output);
	}
	
	/*
	 * 각 검사는 세 줄의 코드를 차지하는데 만약 100개의 경우가 발생하면 최소 300줄 이상 될 것이다.
	 * 더 나은 대안은 switch 문을 사용하는 것이다.
	 */
	@Test
	public void whenSwitchWorksAsMatcher_thenCorrect() {
		int input = 2;
		String output;
		switch (input) {
		case 0:
			output = "zero";
			break;
		case 1:
			output = "one";
			break;
		case 2:
			output = "two";
			break;
		case 3:
			output = "three";
			break;
		default:
			output = "unknown";
			break;
		}
		
		assertEquals("two", output);
	}
	
	/*
	 * 더 나은 것은 아니다. 번호 당 평균 3 줄을 사용한다. break 절을 잊고 개발한다면 
	 * 나중에 발견하기 어려운 버그로 이어질 수 있다.
	 * 
	 * Vavr 를 사용하게 되면 switch 블록을 Match 메서드로 대체할 수 있다.
	 * 각 case, if 문은 Case 메서드 호출로 변경된다.
	 * $() 와 같은 패턴은 표현식이나 값을 평가하는 조건으로 사용한다.
	 * 값을 평가하는 조건은 Case 메서드의 두 번째 인자로 사용한다.
	 * 
	 * Match 를 사용하려면 javaslang 을 maven 의 의존성에 추가해야 한다.
	 */
	@Test
	public void whenMatchworks_thenCorrect() {
		int input = 2;
		String output = Match(input).of(
				Case($(1), "one"),
				Case($(2), "two"),
				Case($(3), "three"),
				Case($(), "?"));
		
		assertEquals("two", output);
	}
	
	/*
	 * 코드가 간결해졌고 검사 블록당 한 줄씩 처리 되었다.
	 * 패턴 매칭 API 는 위의 것 보다 더 강력하고 복잡한 일을 할 수 있다.
	 * 예를 들어 원자 식을 술어로 바꿀 수 있다.
	 * 도움말 및 버전 플래그에 대한 콘솔 명령을 구문 분석한다고 가정하자.
	 * Match(arg).of(
     *     Case($(isIn("-h", "--help")), o -> run(this::displayHelp)),
     *     Case($(isIn("-v", "--version")), o -> run(this::displayVersion)),
     *     Case($(), o -> run(() -> {
     *         throw new IllegalArgumentException(arg);
     *     }))
	 * );
	 */
	
}
