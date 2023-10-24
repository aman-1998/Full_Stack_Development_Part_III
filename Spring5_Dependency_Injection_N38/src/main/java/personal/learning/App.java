package personal.learning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import personal.learning.cars.Altroz;
import personal.learning.cars.Scorpio;
import personal.learning.interfaces.Car;

public class App {
	public static void main(String[] args) {
		Altroz altroz = new Altroz();
		Scorpio scorpio = new Scorpio();
		
//		System.out.println(altroz.specification());
//		System.out.println(altroz.size());
//		System.out.println(scorpio.specification());
//		System.out.println(scorpio.size());
//		System.out.println("--------------------------------------------");
		
//		Car myCar = new Scorpio();
//		System.out.println(myCar.specification());
//		System.out.println("--------------------------------------------");
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Car myCar2 = context.getBean("altroz",Car.class);
		System.out.println(myCar2.specification());
		
		System.out.println("--------------------------------------------");
		
		Car myCar3 = context.getBean("scorpio",Car.class);
		System.out.println(myCar3.specification());
		context.close();
	}
}
