package personal.learning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import personal.learning.cars.Altroz;
import personal.learning.cars.Scorpio;
import personal.learning.interfaces.Car;

public class App {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Car myCar1 = context.getBean("altroz",Car.class);
		System.out.println(myCar1.specification());
		
		System.out.println("--------------------------------------------");
		
		Car myCar2 = context.getBean("scorpio",Car.class);
		System.out.println(myCar2.specification());
		
		System.out.println("--------------------------------------------");
		
		Car myCar3 = context.getBean("tesla",Car.class);
		System.out.println(myCar3.specification());
		
		System.out.println("--------------------------------------------");
		context.close();
	}
}
