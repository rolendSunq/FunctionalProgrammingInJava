package java8.inaction.chapter12.part03;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

public class NextWorkingDayLambda {

	@Test
	public void temporalAdjusterUsing() {
		LocalDate date = LocalDate.of(2021, 2, 7);
		LocalDate workDate = date.with(temporal -> {
			DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
			int dayToAdd = 1;
			if (dow == DayOfWeek.FRIDAY) {
				dayToAdd = 3;
			}
			if (dow == DayOfWeek.SATURDAY) {
				dayToAdd = 2;
			}
			return temporal.plus(dayToAdd, ChronoUnit.DAYS);
		});
		System.out.println("today: " + date);
		System.out.println("work day: " + workDate);
	}
	
	@Test
	public void temporalAdjusterArgUnaryOperator() {
		TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(
				temporal -> {
					DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
					int dayToAdd = 1;
					if (dow == DayOfWeek.FRIDAY) {
						dayToAdd = 3;
					}
					if (dow == DayOfWeek.SATURDAY) {
						dayToAdd = 2;
					}
					
					return temporal.plus(dayToAdd, ChronoUnit.DAYS);
				});
		
		LocalDate today = LocalDate.now();
		LocalDate workDate = today.with(nextWorkingDay);
		System.out.println("today: " + today);
		System.out.println("work day: " + workDate);
	}

}
