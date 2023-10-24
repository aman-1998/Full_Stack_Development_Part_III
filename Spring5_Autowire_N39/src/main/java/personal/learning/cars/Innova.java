package personal.learning.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import personal.learning.interfaces.Car;

@Component("myInnova")
public class Innova implements Car {

	@Autowired
	Engine engine;
	
	public Innova() {
		// This constructor will be used by default.
		engine.setTorque("400 Nm"); //This line will throw NullPointerException(if executed) because engine is not initialized. @Autowired won't work in default constructor
		System.out.println("Hello default constructor of Innova");
		System.out.println("--------------------------------------------");
	}
	
	@Autowired
	public Innova(Engine engine) {
		engine.setTorque("400 Nm");
		System.out.println("Hello parameterized constructor of Innova");
		System.out.println("--------------------------------------------");
	}

	@Override
	public String specification() {
		return this.getClass().getSimpleName()+" is a premium and durable SUV from Toyota. Torque of the engine is "+engine.getTorque();
	}
	
	public String size() {
		return "Huge in size";
	}
}
