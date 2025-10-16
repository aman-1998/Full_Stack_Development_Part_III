package personal.learning.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import personal.learning.interfaces.Car;
import personal.learning.interfaces.Engine;

@Component
public class Altroz implements Car {
	
	@Autowired
	@Qualifier("petrolEngine")
	private Engine engine;

	@Override
	public String specification() {
		return this.getClass().getSimpleName()+" is a Hatchback from Tata Motors. It has a "+engine.type();
	}
	
	public String size() {
		return "Small in size";
	}
	
}
