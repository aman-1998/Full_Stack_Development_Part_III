package personal.learning.cars;

import org.springframework.stereotype.Component;

import personal.learning.interfaces.Car;

@Component
public class Altroz implements Car {

	@Override
	public String specification() {
		return "Hatchback from Tata Motors";
	}
	
	public String size() {
		return "Small in size";
	}
	
}
