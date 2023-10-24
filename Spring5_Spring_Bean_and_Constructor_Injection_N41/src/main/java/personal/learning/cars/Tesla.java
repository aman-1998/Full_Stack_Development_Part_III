package personal.learning.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import personal.learning.interfaces.Car;
import personal.learning.interfaces.Engine;

public class Tesla implements Car {
	
	@Autowired
	@Qualifier("electric")
	Engine engine;

	@Override
	public String specification() {
		return this.getClass().getSimpleName()+" is a premium Sedan. It has a "+engine.type();
	}
	
	public String size() {
		return "Small in size";
	}
	
}
