package personal.learning.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import personal.learning.interfaces.Car;

@Component("myThar")
public class Thar implements Car {

	@Autowired
	Engine engine;
	
	public Thar() {
		// This constructor will be used by default.
		//engine.setTorque("300 Nm"); //This line will throw NullPointerException because engine is not initialized. @Autowired won't work in default constructor
		System.out.println("Hello default constructor of Thar");
		System.out.println("--------------------------------------------");
	}
	
	public Thar(Engine engine) {
		engine.setTorque("300 Nm");
		System.out.println("Hello parameterized constructor of Thar");
		System.out.println("--------------------------------------------");
	}

	@Override
	public String specification() {
		return this.getClass().getSimpleName()+" is a rough and tough SUV from Mahindra. Torque of the engine is "+engine.getTorque();
	}
	
	public String size() {
		return "Large in size";
	}
}
