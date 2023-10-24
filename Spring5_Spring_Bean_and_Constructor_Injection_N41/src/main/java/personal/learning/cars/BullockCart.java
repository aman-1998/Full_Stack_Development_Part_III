package personal.learning.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import personal.learning.interfaces.Car;
import personal.learning.interfaces.Engine;

public class BullockCart implements Car {
	
	@Autowired
	@Qualifier("oxen")
	Engine engine;

	@Override
	public String specification() {
		return this.getClass().getSimpleName()+" is a means of transport in early days. It has "+engine.type();
	}
}
