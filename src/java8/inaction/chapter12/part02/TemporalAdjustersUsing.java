package java8.inaction.chapter12.part02;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

public class TemporalAdjustersUsing {
	/*
	 * TemporalAdjusters 사용하기
	 * 
	 * 다음주 일요일, 돌아오는 평일, 어떤 달의 마지막 날등 복잡한 잘짜를 조정할 필요가 있다.
	 * with 메서드에 다양한 기능을 수행할 수 있도록  TemporalAdjuster를 전달하는 방법으로
	 * 복잡한 날짜를 얻을 수 있다.
	 */
	@Test
	public void varietyTimeZoneCalanderUsing() {
		LocalDate date1 = LocalDate.of(2021, 2, 7);
		LocalDate date2 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
		LocalDate date3 = date2.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("current date: " + date1);
		System.out.println("day of week sunday: " + date2);
		System.out.println("last day of month: " + date3);
	}
	
}
