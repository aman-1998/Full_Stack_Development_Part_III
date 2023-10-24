package personal.learning.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import personal.learning.interfaces.Car;

@Component
public class Nexon implements Car {

	@Autowired
	Engine engine;
	
//	public Nexon() {
//		engine.setTorque("250 Nm");
//		System.out.println("Hello default constructor of Nexon");
//		System.out.println("--------------------------------------------");
//	}
	
	@Autowired
	public Nexon(Engine engine) {
		engine.setTorque("250 Nm");
		System.out.println("Hello parameterized constructor");
		System.out.println("--------------------------------------------");
	}

	@Override
	public String specification() {
		return this.getClass().getSimpleName()+" is a compact SUV from Tata Motors. Torque of the engine is "+engine.getTorque();
	}
	
	public String size() {
		return "Medium in size";
	}
}
