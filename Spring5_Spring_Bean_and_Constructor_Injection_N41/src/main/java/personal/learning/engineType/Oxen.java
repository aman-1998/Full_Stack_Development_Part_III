package personal.learning.engineType;

import personal.learning.interfaces.Engine;

public class Oxen implements Engine {
	
	String type;
	
	public Oxen() {
		this.type="two oxen";
	}
	
	public Oxen(String type) {
		this.type = type;
	}

	@Override
	public String type() {
		return this.type;
	}
}
