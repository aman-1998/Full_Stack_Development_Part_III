package personal.learning.cars;

import org.springframework.beans.factory.annotation.Autowired;

import personal.learning.interfaces.Car;
import personal.learning.interfaces.Engine;

public class Scorpio implements Car {
	
	@Autowired
	Engine dieselEngine; //variable name should be equal to default component name

	@Override
	public String specification() {
		return this.getClass().getSimpleName()+" is a SUV from Mahindra. It has a "+dieselEngine.type();
	}
	
	public String size() {
		return "Large in size";
	}
}
