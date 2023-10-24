package personal.learning.cars;

import org.springframework.stereotype.Component;

import personal.learning.interfaces.Car;

@Component
public class Altroz implements Car {

	@Override
	public String specification() {
		return this.getClass().getSimpleName()+" is a Hatchback from Tata Motors";
	}
	
	public String size() {
		return "Small in size";
	}
	
}
