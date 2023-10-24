package personal.learning.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import personal.learning.interfaces.Car;

@Component
public class Verna implements Car{

	
	Engine engine;
	
//	public Verna() {
//		System.out.println("Hello default constructor of Verna");
//		System.out.println("--------------------------------------------");
//	}
	
	@Autowired
	public Verna(Engine engine) {
		engine.setTorque("280 Nm");
		System.out.println("Hello parameterized constructor of Verna");
		System.out.println("--------------------------------------------");
	}

	@Override
	public String specification() {
		//return "Sedan from Hundai. Torque of the engine is "+engine.getTorque(); // This will give NullPointerException because engine variable is not @Autowired
		return this.getClass().getSimpleName()+" is a Sedan from Hundai";
	}
	
	public String size() {
		return "Large in size";
	}
}
