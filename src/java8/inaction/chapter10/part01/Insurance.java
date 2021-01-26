package java8.inaction.chapter10.part01;

import java.util.Optional;

public class Insurance {
	private String name;
	public String getName() {
		return name;
	}
	
	public Insurance() {
	}

	public Insurance(String name) {
		this.name = name;
	}

	public String getCarInsuranceName(Person person) {
		return person.getCar().getInsurance().getName();
	}
	
	public String getCarInsuranceNameByOptional(Person person) {
		return Optional.ofNullable(person).map(Person::getCar)
				.map(Car::getInsurance)
				.map(Insurance::getName)
				.orElse("Unknown");
	}
	
	public Optional<Insurance> findCheapestInsurance(Optional<Person> person, Optional<Car> car) {
		if (person.isPresent() && car.isPresent()) {
			return Optional.of(findCheapestInsurance(person.get(), car.get()));
		} else {
			return Optional.empty();
		}
	}

	public Insurance findCheapestInsurance(Person person, Car car) {
		// 다양한 보험회사가 제공하는 서비스 조회
		// 모든 결과 데이터 비교
		return new Insurance();
	}
}
