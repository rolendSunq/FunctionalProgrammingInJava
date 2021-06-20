package currying.part01;

public class CurryingUsing {
	/*
	 * BiFunction 으로 생성
	 * BiFunction<String, String, Letter> SIMPLE_LETTER_CREATOR = (salutation, body) -> new Letter(salutation, body);
	 * 
	 * Function 으로 생성
	 * Function<String, Function<String, Letter>> SIMPLE_CURRIED_CREATOR = salutation -> body -> new Letter(salutation, body);
	 */
	
}
