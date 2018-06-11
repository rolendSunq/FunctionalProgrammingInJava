package chapter4.part14.builder_pattern;

public class MailerTestMain {

	public static void main(String[] args) {
		FluentMailer.send(mailer -> 
		mailer.from("build@agiledeveloper.com")
		.to("venkats@agiledeveloper.com")
		.subject("build notification")
		.body("...yout code sucks..."));
		
	}

}
