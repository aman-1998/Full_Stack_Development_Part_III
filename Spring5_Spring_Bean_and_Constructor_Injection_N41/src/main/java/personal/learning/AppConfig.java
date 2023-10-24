package personal.learning;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import personal.learning.cars.Altroz;
import personal.learning.cars.BullockCart;
import personal.learning.cars.Scorpio;
import personal.learning.cars.Tesla;
import personal.learning.engineType.DieselEngine;
import personal.learning.engineType.LithiumIon;
import personal.learning.engineType.Oxen;
import personal.learning.engineType.PetrolEngine;

@Configuration
@ComponentScan("personal.learning")
public class AppConfig {
	
	@Bean("altroz")
	public Altroz altroz() {
		return new Altroz();
	}
	
	@Bean
	public Scorpio scorpio() {
		return new Scorpio();
	}
	
	@Bean("tesla")
	public Tesla tesla() {
		return new Tesla();
	}
	
	//Constructor Injection
	@Bean
	public Oxen oxen() {
		return new Oxen("two bulls");
	}
	
	@Bean("dieselEngine")
	public DieselEngine dieselEngine() {
		return new DieselEngine();
	}
	
	@Bean
	public PetrolEngine petrolEngine() {
		return new PetrolEngine();
	}
	
	@Bean("electric")
	public LithiumIon lithiumIon() {
		return new LithiumIon();
	}
	
	@Bean("oldAgeTransport")
	public BullockCart bullockCart() {
		return new BullockCart();
	}
}
