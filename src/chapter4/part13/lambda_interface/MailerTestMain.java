package chapter4.part13.lambda_interface;

public class MailerTestMain {

	public static void main(String[] args) {
		Mailer mailer = new Mailer();
		mailer.from("build@agiledeveloper.com");
		mailer.to("venkats@agiledeveloper.com");
		mailer.subject("build notification");
		mailer.body("...yout code sucks...");
		mailer.send();
		
		// mailer를 너무 반복한다.
	}

}
