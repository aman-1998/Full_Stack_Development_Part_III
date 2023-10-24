package personal.learning.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import personal.learning.interfaces.Car;

@Component("seltos")
public class Seltos implements Car {

	Engine engine;
	
	public Seltos() {
		System.out.println("Hello default constructor of Seltos");
		System.out.println("--------------------------------------------");
	}
	
	@Autowired
	public void setEngine(Engine engine) {
		System.out.println("Hello setter method of Engine in Seltos");
		System.out.println("--------------------------------------------");
		engine.setTorque("260 Nm");
		this.engine = engine; // We can't comment this line. Otherwise we will get NullPointerException
	}

	@Override
	public String specification() {
		return this.getClass().getSimpleName()+" is a stylish SUV from Kia. Torque of the engine is "+engine.getTorque();
	}
	
	public String size() {
		return "Large in size";
	}
}
