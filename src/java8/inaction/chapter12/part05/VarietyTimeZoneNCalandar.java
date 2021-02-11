package java8.inaction.chapter12.part05;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

import org.junit.Test;

public class VarietyTimeZoneNCalandar {
	/*
	 * java.time.ZoneId 클래스
	 * 서머타임(Daylight Saving Time [DST])과 같은 복잡한 시간등을 자동으로 처리한다.
	 * ZoneId 클래스는 불변 클래스이다.
	 * 표준 시간이 같은 지역을 묶어서 시간대 규정을 할수있다. 
	 * ZoneRules 클래스에 약 40개 정도의 시간대가 있다.
	 * ZoneId의 getRules() 메서드를 이용하여 해당 시간대 정보를 얻을 수 있다.
	 * 
	 */
	@Test
	public void zoneIdUsing() {
		ZoneId romeZone = ZoneId.of("Europe/Rome");
		System.out.println("ZoneId: " + romeZone);
	}
	
	/*
	 * 지역 ID는 '{지역}/{도시}' 형식으로 구성되며 IANA Time Zone Database에서 
	 * 제공되는 지역 집합 정보를 사용한다.
	 * ZoneId의 메소드 중 toZoneId 로 기존의 TimeZone 객체를 ZoneId 객체로 변환할 수 있다.
	 * 
	 */
	@Test
	public void convertZoneId() {
		ZoneId zoneId = TimeZone.getDefault().toZoneId();
		System.out.println("default ZoneId: " + zoneId);
	}
	
	/*
	 * ZoneId 객체를 얻은 다음에 LocalDate, LocalDateTime, Instant를 이용하여
	 * ZonedDateTime 인스턴스로 변환할 수 있다.
	 * ZonedDateTime 은 지정한 시간대에 상대적인 시점을 표현한다.
	 */
	@Test
	public void setCertainViewPointTimeZone() {
		ZoneId romeZone = ZoneId.of("Europe/Rome");
		LocalDate date = LocalDate.of(2021, Month.FEBRUARY, 10);
		ZonedDateTime zdt1 = date.atStartOfDay(romeZone);
		System.out.println("romeZone date time:" + zdt1);
		
		LocalDateTime dateTime = LocalDateTime.of(2021, Month.FEBRUARY, 10, 18, 4);
		ZonedDateTime zdt2 = dateTime.atZone(romeZone);
		System.out.println("romeZone date time:" + zdt2);
		
		Instant instant = Instant.now();
		ZonedDateTime zdt3 = instant.atZone(romeZone);
		System.out.println("romeZone date time:" + zdt3);
		
	}
}
