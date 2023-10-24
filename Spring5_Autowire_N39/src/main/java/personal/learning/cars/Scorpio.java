package personal.learning.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import personal.learning.interfaces.Car;

@Component
public class Scorpio implements Car {
	
	@Autowired
	Engine engine;

	@Override
	public String specification() {
		return this.getClass().getSimpleName()+" is a SUV from Mahindra. Torque of the engine is "+engine.getTorque();
	}
	
	public String size() {
		return "Large in size";
	}
}
