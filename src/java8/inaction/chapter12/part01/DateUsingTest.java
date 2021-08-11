package java8.inaction.chapter12.part01;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.junit.Test;

public class DateUsingTest {
	@Test
	public void DateClassTest() {
		@SuppressWarnings("deprecation")
		Date date = new Date(114, 2, 18);
		System.out.println("Date " + date);
	}
	
	@Test
	public void ofUsing() {
		// static method of로 LocalDate 인스턴스를 만들 수 있다.
		LocalDate date = LocalDate.of(2014, 3, 18);
		int year = date.getYear();
		Month month = date.getMonth();
		int day = date.getDayOfMonth();
		DayOfWeek dow = date.getDayOfWeek();
		int len = date.lengthOfMonth();
		// 윤년 여부
		boolean leap = date.isLeapYear();
		System.out.println("year: " + year);
		System.out.println("month: " + month); 
		System.out.println("day: " + day);
		System.out.println("Day of Week:" + dow);
		System.out.println("length of Month: " + len);
		System.out.println("is leap of Year: " + leap);
	}
	
	@Test
	public void nowUsing() {
		// now는 시스템 시계의 정보를 이용해서 현재 날짜 정보를 얻는다.
		LocalDate today = LocalDate.now();
		System.out.println("today: " + today);
	}
	
	@Test
	public void chronoField_Using() {
		LocalDate date = LocalDate.now();
		int year = date.get(ChronoField.YEAR);
		int month = date.get(ChronoField.MONTH_OF_YEAR);
		int day = date.get(ChronoField.DAY_OF_MONTH);
		System.out.println("year: " + year);
		System.out.println("month: " + month);
		System.out.println("day: " + day);
	}
	
	@Test
	public void localTime_Using() {
		LocalTime time = LocalTime.of(13, 45, 20);
		int hour = time.getHour();
		int minute = time.getMinute();
		int second = time.getSecond();
		System.out.println("*****************");
		System.out.println("hour: " + hour);
		System.out.println("minute: " + minute);
		System.out.println("second: " + second);
		System.out.println("*****************");
	}
	
	@Test
	public void parseUsing() {
		LocalDate date = LocalDate.parse("2021-02-05");
		LocalTime time = LocalTime.parse("13:45:20");
		System.out.println("*****************");
		System.out.println("date: " + date);
		System.out.println("time: " + time);
		System.out.println("*****************");
	}
	
	@Test
	public void localDateTimeUsing() {
		LocalDate date = LocalDate.parse("2021-02-05");
		LocalTime time = LocalTime.parse("23:45:33");
		LocalDateTime dt1 = LocalDateTime.of(2012, Month.MARCH, 18, 13, 45, 20);
		LocalDateTime dt2 = LocalDateTime.of(date, time);
		LocalDateTime dt3 = date.atTime(13, 45, 20);
		LocalDateTime dt4 = date.atTime(time);
		LocalDateTime dt5 = time.atDate(date);
		LocalDate date1 = dt1.toLocalDate();
		LocalTime time1 = dt1.toLocalTime();
		System.out.println("dt1: " + dt1);
		System.out.println("dt2: " + dt2);
		System.out.println("dt3: " + dt3);
		System.out.println("dt4: " + dt4);
		System.out.println("dt5: " + dt5);
		System.out.println("date1: " + date1);
		System.out.println("time1: " + time1);
	}
	
	@Test
	public void epochTimeUsing() {
		Instant et1 = Instant.ofEpochSecond(3);
		Instant et2 = Instant.ofEpochSecond(3, 0);
		Instant et3 = Instant.ofEpochSecond(2, 1_000_000_000);
		Instant et4 = Instant.ofEpochSecond(4, -1_000_000_000);
		System.out.println("et1: " + et1);
		System.out.println("et2: " + et2);
		System.out.println("et3: " + et3);
		System.out.println("et4: " + et4);
	}
	
	@Test
	public void durationNperiodUsing() {
		LocalTime time1 = LocalTime.parse("09:00");
		LocalTime time2 = LocalTime.parse("10:00");
		LocalDateTime dateTime1 = LocalDateTime.of(2021, Month.FEBRUARY, 6, 9, 0, 0);
		LocalDateTime dateTime2 = LocalDateTime.of(2021, Month.FEBRUARY, 6, 10, 0, 0);
		Instant instant1 = Instant.ofEpochSecond(3);
		Instant instant2 = Instant.ofEpochSecond(4);
		@SuppressWarnings("unused")
		Duration d1 = Duration.between(time1, time2);
		@SuppressWarnings("unused")
		Duration d2 = Duration.between(dateTime1, dateTime2);
		@SuppressWarnings("unused")
		Duration d3 = Duration.between(instant1, instant2);
		Period tenDays = Period.between(LocalDate.of(2014, 3, 8), LocalDate.of(2014, 3, 18));
		System.out.println("Period tenDays: " + tenDays);
	}
	
	@Test
	public void durationNperiodUsing2() {
		Duration threeMinutes = Duration.ofMinutes(3);
		Duration threeMinutesII = Duration.of(3, ChronoUnit.MINUTES);
		
		Period tenDays = Period.ofDays(10);
		Period threeWeeks = Period.ofWeeks(3);
		Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
		
		System.out.println("threeMinutes " + threeMinutes.toMinutes());
		System.out.println("threeMinutesII " + threeMinutesII.toMinutes());
		System.out.println("tenDays " + tenDays.getDays());
		System.out.println("threeWeeks " + threeWeeks.getDays());
		System.out.println("twoYearsSixMonthsOneDay " + twoYearsSixMonthsOneDay.getDays());
	}
	
	/*
	 * 날짜 조정, 파싱 포매팅
	 * 
	 * with[Arrtibute] method 로 기존의 LocalDate를 바꾼 버전을 직접 간단하게 만들 수 있다.
	 * 모든 메서드는 기존 객체를 바꾸지 않는다.
	 * 
	 * TemporalField를 갖는 메서드를 사용하면 범용적 메서드를 사용할 수 있다.
	 * (static) from : 주어진 Temporal 객체를 이용해서 클래스의 인스턴스를 생성함.
	 * (static) now : 시스템 시계로 Temporal 객체를 생성함.
	 * (static) of : 주어진 구성 요소에서 Temporal 객체의 인스턴스를 생성함.
	 * (static) parse : 문자열을 파싱해서 Temporal 객체를 생성함
	 * atOffset : 시간대 오프셋과 Temporal 객체를 생성함.
	 * atZone : 시간대와 Temporal 객체를 합침.
	 * format : 지정된 포매터를 이용해서 Temporal 객체를 문자열로 변환함(Instant는 지원하지 않음).
	 * get : Temporal 객체의 상태를 읽음.
	 * minus : 특정 시간을 뺀 Temporal 객체의 복사본을 생성함.
	 * plus : 특정 시간을 더한 Temporal 객체의 복사본을 생성함.
	 * with : 일부 상태를 바꾼 Temporal 객체의 복사본을 생성함.
	 * 
	 * Temporal 객체의 지정된 필드를 지원하지 않으면 UnsupprotedTemporalTypeException이 발생한다.
	 * 
	 */
	@Test
	public void formattingParsingDateChange() {
		LocalDate date1 = LocalDate.of(2021, 2, 7);
		LocalDate date2 = date1.withYear(2020);
		LocalDate date3 = date2.withDayOfMonth(25);
		LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 3);
		System.out.println("set Date: " + date1);
		System.out.println("date1.withYear(2020): " + date2);
		System.out.println("date2.withDayOfMonth(25): " + date3);
		System.out.println("date3.with(ChronoField.MONTH_OF_YEAR, 3): " + date4);
	}
	
	@Test
	public void temporalInterfaceFieldUsing() {
		LocalDate date1 = LocalDate.of(2021, 2, 07);
		LocalDate date2 = date1.plusWeeks(1);
		LocalDate date3 = date2.minusYears(3);
		LocalDate date4 = date3.plus(6, ChronoUnit.MONTHS);
		System.out.println("LocalDate.of(2021, 2, 07): " + date1);
		System.out.println("date1.plusWeeks(1): " + date2);
		System.out.println("date2.minusYears(3): " + date3);
		System.out.println("date3.plus(6, ChronoUnit.MONTHS): " + date4);
	}
}
