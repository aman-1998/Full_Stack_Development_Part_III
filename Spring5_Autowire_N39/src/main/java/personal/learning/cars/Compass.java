package personal.learning.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import personal.learning.interfaces.Car;

@Component
public class Compass implements Car {
	
	@Autowired
	Engine engine;
	
	public Compass() {
		System.out.println("Hello default constructor of Compass");
		System.out.println("--------------------------------------------");
	}
	
	
	public void setEngine(Engine engine) {
		System.out.println("Hello setter method of Engine in Compass");
		System.out.println("--------------------------------------------");
		engine.setTorque("420 Nm");
		//this.engine = engine;
	}

	@Override
	public String specification() {
		return this.getClass().getSimpleName()+" is a premium and powerful SUV from Jeep. Torque of the engine is "+engine.getTorque();
	}
	
	public String size() {
		return "Large in size";
	}
}
