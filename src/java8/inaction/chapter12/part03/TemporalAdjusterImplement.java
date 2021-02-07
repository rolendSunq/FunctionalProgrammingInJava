package java8.inaction.chapter12.part03;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class TemporalAdjusterImplement {
	/*
	 * TemporalAdjuster 인터페이스
	 * 
	 * @FunctionalInterface
	 * public interface TemporalAdjuster {
	 *     Temporal adjustInto(Temporal temporal);
	 * }
	 * 
	 * TemporalAdjuster 인터페이스 구현은 Temporal 객체를 어떻게 다른 Temporal 객체로 
	 * 변환할지 정의한다. 결국 TemporalAdjuster 인터페이스를 UaryOperator<Temporal> 
	 * 과 같은 형식으로 간주할 수 있다.
	 * 
	 * TemporalAdjuster 인터페이스를 구현하는 NextWorkingDay 클래스를 구현하라.
	 * 이 클래스는 날짜를 하루씩 다음날로 바꾸는데 이때 토요일과 일요일은 건너뛴다.
	 * 다음날이 토요일이면 3일을 건너뛴다.
	 * 다음날이 일요일이면 2일을 건너뛴다.
	 * 
	 * 만일 이동된 날짜가 평일이 아니면, 즉 토요일이나 일요일이면 월요일로 이동한다.
	 */
	
	public class NextWorkingDay implements TemporalAdjuster {

		@Override
		public Temporal adjustInto(Temporal temporal) {
			// 현재 날짜 읽기
			DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
			// 기본적으로 하루 추가
			int dayToAdd = 1;
			// 현재일이 금요일이면 3일 추가
			if (dow == DayOfWeek.FRIDAY) {
				dayToAdd = 3;
			} else if (dow == DayOfWeek.SATURDAY) { // 토요일이면 2일 추가
				dayToAdd = 2;
			}
			
			// 적정한 날 수 많큼 추가된 날짜를 반환
			return temporal.plus(dayToAdd, ChronoUnit.DAYS);
		}
		
	}
}
