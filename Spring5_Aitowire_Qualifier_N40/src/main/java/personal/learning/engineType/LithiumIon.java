package personal.learning.engineType;

import org.springframework.stereotype.Component;

import personal.learning.interfaces.Engine;

@Component("electric")
public class LithiumIon implements Engine {

	@Override
	public String type() {
		return "Lithium Ion Battery Engine";
	}
	
}
