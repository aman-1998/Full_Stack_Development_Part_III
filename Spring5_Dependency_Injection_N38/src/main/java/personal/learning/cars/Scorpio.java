package personal.learning.cars;

import org.springframework.stereotype.Component;

import personal.learning.interfaces.Car;

@Component
public class Scorpio implements Car {

	@Override
	public String specification() {
		return "SUV from Mahindra";
	}
	
	public String size() {
		return "Large in size";
	}
}
