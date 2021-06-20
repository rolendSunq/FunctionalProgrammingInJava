package currying.part02;

import java.time.LocalDate;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Letter {
	private String returningAddress;
	private String insideAddress;
	private LocalDate dateOfLetter;
	private String salutation;
	private String body;
	private String closing;
	
	public Letter(String salutation, String body) {
		this(null, null, LocalDate.now(), salutation, body, null);
	}
	
	public Letter(String returningAddress, String insideAddress, LocalDate dateOfLetter, String salutation, String body, String closing) {
		super();
		this.returningAddress = returningAddress;
		this.insideAddress = insideAddress;
		this.dateOfLetter = dateOfLetter;
		this.salutation = salutation;
		this.body = body;
		this.closing = closing;
	}

	public Letter createLetter(String returningAddress, String insideAddress, LocalDate dateOfLetter, String salutation, String body, String closing) {
		return new Letter(returningAddress, insideAddress, dateOfLetter, salutation, body, closing);
	}
	
	public static BiFunction<String, String, Letter> SIMPLE_LETTER_CREATOR = 
			(salutation, body) -> new Letter(salutation, body);
			
	public static Function<String, Function<String, Letter>> simpleCurriedLetterCreater() { 
		return salutation -> body -> new Letter(salutation, body);
	}

	@Override
	public String toString() {
		return new StringBuffer().append("Letter [returningAddress=").append(returningAddress)
				.append(", insideAddress=").append(insideAddress)
				.append(", dateOfLetter=").append(dateOfLetter)
				.append(", salutation=").append(salutation)
				.append(", body=").append(body)
				.append(", closing=").append(closing)
				.append("]").toString();
	}
	
}
