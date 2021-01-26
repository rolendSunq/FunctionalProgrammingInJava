package java8.inaction.chapter10.part01_B;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class OptionalUsing {
	@Test
	public void whenCreateEmptyOptional_thenCorrect() {
		/*
		 * 빈 Optional 객체 생성은 empty() 메서드를 사용하면 된다.
		 */
		Optional<String> empty = Optional.empty();
		// Optional 객체에 값이 있는지 확인 하기위해 isPresent메서드 사용
		// Optional 생성하여 null 값이 있는 경우 값이 존재한다.
		assertFalse(empty.isPresent());
	}
	
	@Test
	public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
		String name = "baeldung";
		// 메서드 of()를 사용하여 Optional 객체를 만들 수도 있다.
		// 실제 value가 존재하면 of() 메서드를 사용하자.
		Optional<String> opt = Optional.of(name);
		assertTrue(opt.isPresent());
	}
	
	@Test(expected = NullPointerException.class)
	public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
		String name = null;
		// of()메서드에 전달 인수는 value가 존재해야 한다. 그렇지 않으면 NullPointerException이 발생한다.
		Optional.of(name);
	}
	
	@Test
	public void givenNonNull_whenCreateNullable_thenCorrect() {
		String name = "baeldung";
		// null 값이 예상되는 경우 ofNullable()메서드를 사용할 수 있다.
		Optional<String> opt = Optional.ofNullable(name);
		assertTrue(opt.isPresent());
	}
	
	@Test
	public void givenNull_whenCreateNullable_thenCorrect() {
		String name = null;
		// ofNullalbe()메서드로 null 참조를 전달하면 예외는 발생하지 않고 빈 Optional 객체가 반환된다.
		Optional<String> opt = Optional.ofNullable(name);
		assertFalse(opt.isPresent());
	}
	
	@Test
	public void givenOptional_whenIsPresentWorks_thenCorrect() {
		Optional<String> opt = Optional.of("Baeldung");
		
		// isPresent()는 Optional 객체가 있을때 값이 있는지 여부를 확인할 수 있다.
		assertTrue(opt.isPresent());
		
		opt = Optional.ofNullable(null);
		assertFalse(opt.isPresent());
	}
	
	/*
	@Test
	public void givenAnEmptyOptional_thenIsEmptyBehavesAsExpected() {
		Optional<String> opt = Optional.of("Baeldung");
		// Java 11 부터 isEmpty 메서드를 사용 하여 반대의 작업을 수행 할 수 있다.
		assertFalse(opt.isEmpty());
		
		opt = Optional.ofNullable(null);
		assertTrue(opt.isEmpty());
	}
	*/
	
	
	/*
	 * if (name != null) System.out.println(name.length());
	 * null 검사 여부는 많은 시간을 요구하며(?), 오류를 발생하기 쉽다. 그 예로
	 * null 검사를 메서드로 만들고 잊어버리고 null 검사를 처리를 생략하면 이해할 것이다.
	 * 좋은 해결 방법은 nullable 값을 명시적으로 처리하게 하면 된다.
	 */
	@Test
	public void givenOptional_whenIfPresentWorks_thenCorrect() {
		Optional<String> opt = Optional.of("baeldung");
		opt.ifPresent(name -> System.out.println(name.length()));
	}
	
	/*
	 * Optional 클래스는 실제 사용하는 타입의 래퍼 클래스이다.
	 * orElse()메서드는 내부 타입에 대해 관련되어 있다.
	 * orElse()메서드의 인자 값으로 내부 타입의 값을 초기화 한다. 
	 */
	@Test
	public void whenElseWorks_thenCorrect() {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElse("john");
		assertEquals("john", name);
	}
	
	/*
	 * orElseGet()메서드는 orElse()메서드와 유사하다.
	 * 하지만 Optional 값이 없는 경우 반환할 값을 Supplies 인터페이스를 사용하여 대신 호출되어 
	 * 값을 반환한다.
	 */
	@Test
	public void whenOdrElseGetWorks_thenCorrect() {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
		assertEquals("john", name);
	}
	
	public String getMyDefault() {
		System.out.println("Getting Default Value");
		return "Default Value";
	}
	
	
	/*
	 * orElse()와 orElseGet()의 차이점 
	 * 결과는 같다.
	 */
	@Test
	public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
		String text = null;
		
		String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
		assertEquals("Default Value", defaultText);
		
		defaultText = Optional.ofNullable(text).orElse(getMyDefault());
		assertEquals("Default Value", defaultText);
	}
	
	/*
	 * 기본 조건은 기본값은 없어야 하지만 기본 값을 생성하고 결과를 확인하자.
	 * orElseGet()은 래핑 된 값을 검색할 때 포함된 값이 있기 때문에  getMyDefault()메서드를 
	 * 호출하지 않는다.
	 * 그러나 orElse()메서드는 래핑 된 값의 여부와 관계 없이 getMyDefault()메서드를 호출하여
	 * 기본 객체를 생성한다.
	 */ 
	@Test
	public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
		String text = "Text present";
		
		System.out.println("Using orElseGet:");
		String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
		assertEquals("Text present", defaultText);
		
		System.out.println("Using orElse:");
		defaultText = Optional.ofNullable(text).orElse(getMyDefault());
		assertEquals("Text present", defaultText);
	}
	
	/*
	 * orElseThrow()메소드는 orElse()와 orElseGet()그리고 null 값을 처리하기 위해 사용된다.
	 * 래핑된 값이 없을 때 기본 값을 반환하는 대신 예외가 발생한다.
	 * Java 8은 예외 생성자를 인자로 전달한다.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void whenOrElseThrowWorks_thenCorrect() {
		String nullName = null;
		@SuppressWarnings("unused")
		String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
	}
	
	/*
	 * Java 10에는 orElseThrow()메서드는 인수 없이 단순화 되어 사용한다.
	 * @Test(expected = NoSuchElementException.class)
	 * public void whenNoArgOrElseThrowWorks_thenCorrect() {
	 *     String nullName = null;
	 *     String name = Optional.ofNullable(nullName).orElseThrow();
	 * }
	 */
	
	/*
	 * 래핑 된 값을 검색하기 위해 get()메서드를 사용한다.
	 */
	@Test
	public void givenOptional_whenGetsValue_thenCorrect() {
		Optional<String> opt = Optional.of("baeldung");
		String name = opt.get();
		assertEquals("baeldung", name);
	}
	
	/*
	 * get()은 래핑된 객체가 null이 아닌 경우에만 값을 반환하며 아닐 경우
	 * 해당 요소 없음의 예외가 발생한다.
	 * Optional의 목적은 이런 예기치 않은 예외를 방지하는 것인데 오히려
	 * 예외를 만드는 get()메소드가 되었다.
	 * 향후 업데이트된 버전에서는 더 이상 사용되지 않을 것이다.
	 */
	@Test(expected = NoSuchElementException.class)
	public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
		Optional<String> opt = Optional.ofNullable(null);
		@SuppressWarnings("unused")
		String name = opt.get();
	}
	
	/*
	 * filter()를 사용한 조건부 반환
	 * 이 메서드를 사용하여 래핑 된 값에 대해 인라인 테스트를 실행할 수 있다.
	 * 인수로 Functional Interface을 사용하며 Optional class를 반환한다.
	 * Functional Interface에 의한 테스트를 통과 하면 Optional이 반환되며
	 * false 이면 빈 Optional을 반환한다.
	 */
	@Test
	public void whenOptionalFilterWorks_thenCorrect() {
		Integer year = 2016;
		Optional<Integer> yearOptional = Optional.of(year);
		boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
		assertTrue(is2016);
		boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
		assertFalse(is2017);
	}
	
	public boolean priceIsInRange1(Modem modem) {
		boolean isInRange = false;
		
		if (modem != null && modem.getPrice() != null && (modem.getPrice() >= 10)
				&& modem.getPrice() <= 15) {
			isInRange = true;
		}
		
		return isInRange;
	}
	
	@Test
	public void whenFiltersWithoutOptional_thenCorrect() {
		assertTrue(priceIsInRange1(new Modem(10.0)));
		assertFalse(priceIsInRange1(new Modem(9.9)));
		assertFalse(priceIsInRange1(new Modem(null)));
		assertFalse(priceIsInRange1(new Modem(15.5)));
		assertFalse(priceIsInRange1(null));
	}
	
	public boolean priceIsRange2(Modem modem2) {
		return Optional.ofNullable(modem2)
				.map(Modem::getPrice)
				.filter(p -> p >= 10)
				.filter(p -> p <= 15)
				.isPresent();
	}
	
	@Test
	public void whenFilterWithOptional_thenCorrect() {
		assertTrue(priceIsRange2(new Modem(10.0)));
		assertFalse(priceIsRange2(new Modem(9.9)));
		assertFalse(priceIsRange2(new Modem(null)));
		assertFalse(priceIsRange2(new Modem(15.5)));
		assertFalse(priceIsRange2(null));
	}
	
	/*
	 * map()은 단순히 다른 값으로 값을 변환하는 데 사용한다. 
	 * 또한 map()으로 Optional값을 변환할 수 있다.
	 */
	@Test
	public void givenOptional_whenMapWorks_thenCorrect() {
		List<String> companyNames = Arrays.asList(
				"paypal", "oracle", "", "microsoft", "", "apple");
		Optional<List<String>> listOptional = Optional.of(companyNames);
		
		int size = listOptional.map(List::size)
				.orElse(0);
		assertEquals(6, size);
	}
	
	@Test
	public void givenOptional_whenMapWorks_thenCorrect2() {
		String name = "baeldung";
		Optional<String> nameOptional = Optional.of(name);
		
		int len = nameOptional.map(String::length)
				.orElse(0);
		assertEquals(8, len);
	}
	
	@Test
	public void givenOptional_whenMapWorksWithFilter_thenCorrect() {
		String password = " password ";
		Optional<String> passOpt = Optional.of(password);
		boolean correctPassword = passOpt.filter(pass -> pass.equals("password")).isPresent();
		assertFalse(correctPassword);
		
		correctPassword = passOpt.map(String::trim)
				.filter(pass -> pass.equals("password"))
				.isPresent();
		assertTrue(correctPassword);
	}
	
	/*
	 * flatMap
	 * 중첩 된 Optional 인스턴스의 래핑 처리
	 * assert를 실행하기 위해 Person 객체의 name property를 검색하려 한다.
	 * map()메서드로 name을 처리한 후 flatMap()메서드로 동일 작업을 수행한다.
	 * getName()메서드는 Optional 객체를 반환하며 결국 중첩된 Optional로 수행된다.
	 * map()메서드를 사용시 변환되기 전의 값을 검색해야 하며 그 결과로 
	 * Optional Wrapper가 제거된 상태로 반환한다. 
	 * flatMap()메소드가 Optional Wrapper를 제거한다.
	 */
	@Test
	public void givenOptional_whenFlatMapWorks_thenCorrect2() {
		Person person = new Person("john", 26);
		Optional<Person> personOptional = Optional.of(person);
		
		Optional<Optional<String>> nameOptionalWrapper = personOptional.map(Person::getName);
		Optional<String> nameOptional = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
		String name1 = nameOptional.orElse("");
		assertEquals("john", name1);
		
		String name = personOptional.flatMap(Person::getName)
				.orElse("");
		assertEquals("john", name);
	}
	
	private Optional<String> getEmpty() {
		return Optional.empty();
	}
	
	private Optional<String> getHello() {
		return Optional.of("hello");
	}
	
	private Optional<String> getBye() {
		return Optional.of("bye");
	}
	
	private Optional<String> createOptional(String input) {
		if (input == null || "".equals(input) || "empty".equals(input)) {
			return Optional.empty();
		}
		
		return Optional.of(input);
		
	}
	
	/*
	 * 여러개의 선택 (chain) 조건을 사용하여 null 이 아닌 객체를 가져오기 위해
	 * Stream API를 사용할 수 있다. 
	 */
	@Test
	public void givenThreeOptionals_whenChaining_thenFirstNonEmptyIsReturned() {
		Optional<String> found = Stream.of(getEmpty(), getHello(), getBye())
				.filter(Optional::isPresent)
				.map(Optional::get)
				.findFirst();
		
		assertEquals(getHello(), found);
	}
	
	/*
	 * 인수를 받는 메서드를 사용해야 하는 경우 람다 식을 사용한다.
	 */
	@Test
	public void givenTwoOptionalsReturnedByOneArgMethod_whenChaining_thenFirstNonEmptyIsResurned() {
		Optional<String> found = Stream.<Supplier<Optional<String>>>of(
				() -> createOptional("empty"),
				() -> createOptional("hello")
				).map(Supplier::get)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.findFirst();
		
		assertEquals(createOptional("hello"), found);
	}
	
	/*
	 * Optional이 비어있는 경우 orElse()또는 orElseGet()호출을 추가한다.
	 */
	@Test
	public void givenTwoEmptyOptionals_whenChaining_thenDefaultIsReturned() {
		String found = Stream.<Supplier<Optional<String>>>of(
				() -> createOptional("empty"),
				() -> createOptional("empty")
				).map(Supplier::get)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.findFirst()
				.orElseGet(() -> "default");
		
		assertEquals("default", found);
	}
	
	/*
	 * Optional의 오용
	 * Optional을 사용함에 있어서 유혹적이지만 위험한 방법들이 있다.
	 * Optional의 메서드의 매개 변수를 메서드에 전달
	 * Person 객체 List가 있고 그 List에서 주어진 이름을 가진 사람들을 검색한다.
	 * 그리고 해당 메소드가 특정 연령 이상의 List를 갖길 원한다.
	 * 
	 */
	public  static List<Person> search(List<Person> people, String name, Optional<Integer> age) {
		// Null checks for people and name
		return people.stream()
				.filter(p -> p.getName().equals(name))
				.filter(p -> p.getAge().get() >= age.orElse(0))
				.collect(Collectors.toList());
	}
	
	/*
	 * NullPointerException 방지를 위해 매개 변수의 null 검사를 해야한다.
	 * search()메서드를 수정한다.
	 */
	public static List<Person> search(List<Person> people, String name, Integer age) {
		final Integer ageFilter = age != null ? age : 0;
		
		return people.stream()
				.filter(p -> p.getName().equals(name))
				.filter(p -> p.getAge().get() >= ageFilter)
				.collect(Collectors.toList());
	}
}
