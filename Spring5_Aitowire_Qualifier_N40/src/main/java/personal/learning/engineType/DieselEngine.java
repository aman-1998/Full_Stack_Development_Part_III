package personal.learning.engineType;

import org.springframework.stereotype.Component;

import personal.learning.interfaces.Engine;

@Component
public class DieselEngine implements Engine {

	@Override
	public String type() {
		return "Diesel Engine";
	}

}
