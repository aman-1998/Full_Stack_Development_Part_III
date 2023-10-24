package personal.learning.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import personal.learning.interfaces.Car;

@Component
public class Jimny implements Car {
	
	@Autowired
	Engine engine;
	
//	public Jimny() {
//		System.out.println("Hello default constructor of Jimny");
//		System.out.println("--------------------------------------------");
//	}
	
	public Jimny(Engine engine) {
		engine.setTorque("130 Nm");
		System.out.println("Hello parameterized constructor of Jimny");
		System.out.println("--------------------------------------------");
	}

	@Override
	public String specification() {
		return this.getClass().getSimpleName()+" is a rough and tough SUV from Maruti-Suzuki. Torque of the engine is "+engine.getTorque();
	}
	
	public String size() {
		return "Small in size";
	}
}
