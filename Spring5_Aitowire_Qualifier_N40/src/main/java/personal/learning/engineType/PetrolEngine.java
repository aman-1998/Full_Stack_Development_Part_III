package personal.learning.engineType;

import org.springframework.stereotype.Component;

import personal.learning.interfaces.Engine;

@Component
public class PetrolEngine implements Engine {

	@Override
	public String type() {
		return "Petrol Engine";
	}

}
