package personal.learning.cars;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	private String torque;
	
	public Engine() {
		this.torque = "320 Nm";
		System.out.println("Hello default constructor of Engine");
		System.out.println("--------------------------------------------");
	}

	public String getTorque() {
		return torque;
	}

	public void setTorque(String torque) {
		this.torque = torque;
	}
}
