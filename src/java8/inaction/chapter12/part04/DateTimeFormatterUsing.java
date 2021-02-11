package java8.inaction.chapter12.part04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.junit.Test;

public class DateTimeFormatterUsing {
	@Test
	public void formatterUsing() {
		LocalDate date = LocalDate.of(2021, 2, 8);
		String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
		String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println("DateTimeFormatter.BASIC_ISO_DATE: " + s1);
		System.out.println("DateTimeFormatter.ISO_LOCAL_DATE: " + s2);
	}
	
	@Test
	public void patternUsing() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1 = LocalDate.of(2021, 2, 9);
		String formattedDate = date1.format(formatter);
		System.out.println("formattedDate: " + formattedDate);
		LocalDate date2 = LocalDate.parse(formattedDate, formatter);
		System.out.println("dd/MM/yyyy:" + date2);
	}
	
	@Test
	public void makeLocalDateTimeformatter() {
		System.out.println("*****local DateTimeFormatter*****");
		LocalDate date = LocalDate.of(2020, 10, 10);
		DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
		LocalDate date1 = LocalDate.of(2021, 2, 9);
		System.out.println("date1: " + date1);
		String formattedDate = date.format(italianFormatter);
		System.out.println("date.format(italianFormatter): " + formattedDate);
		LocalDate date2 = LocalDate.parse(formattedDate, italianFormatter);
		System.out.println("date2: " + date2);
		System.out.println("*********************************");
	}
	
	@Test
	public void makeDateTimeFormatter() {
		LocalDate date = LocalDate.of(2011, 1, 21);
		DateTimeFormatter italianFormatter = new DateTimeFormatterBuilder()
				.appendText(ChronoField.DAY_OF_MONTH)
				.appendLiteral(". ")
				.appendText(ChronoField.MONTH_OF_YEAR)
				.appendLiteral(" ")
				.appendText(ChronoField.YEAR)
				.parseCaseInsensitive()
				.toFormatter(Locale.ITALIAN);
		String formattedDate = date.format(italianFormatter);
		System.out.println("Italian Format Date: " + formattedDate);
		LocalDate nowItaliDate = LocalDate.now();
		String italiForamatNow = nowItaliDate.format(italianFormatter);
		System.out.println("Itali Now: " + italiForamatNow);
	}
}
