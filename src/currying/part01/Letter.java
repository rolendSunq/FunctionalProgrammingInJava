package currying.part01;

public class Letter {
	private String salutation;
	private String body;
	
	public Letter(String salutation, String body) {
		this.salutation = salutation;
		this.body = body;
	}
	
	public Letter createLetter(String salutation, String body) {
		return new Letter(salutation, body);
	}
	
	public final String getSalutation() {
		return salutation;
	}

	public final void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public final String getBody() {
		return body;
	}

	public final void setBody(String body) {
		this.body = body;
	}
	
}
