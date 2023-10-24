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
		
		System.out.println("*********************************************************");
		Car myCar1 = context.getBean("altroz",Car.class);
		System.out.println(myCar1.specification());
		
		System.out.println("--------------------------------------------");
		
		Car myCar2 = context.getBean("scorpio",Car.class);
		System.out.println(myCar2.specification());
		
		System.out.println("--------------------------------------------");
		
		Car myCar3 = context.getBean("myThar",Car.class);
		System.out.println(myCar3.specification());
		
		System.out.println("--------------------------------------------");
		
		Car myCar4 = context.getBean("jimny",Car.class);
		System.out.println(myCar4.specification());
		
		System.out.println("--------------------------------------------");
		
		Car myCar5 = context.getBean("verna",Car.class);
		System.out.println(myCar5.specification());
		
		System.out.println("--------------------------------------------");
		
		Car myCar6 = context.getBean("nexon",Car.class);
		System.out.println(myCar6.specification());
		
		System.out.println("--------------------------------------------");
		
		Car myCar7 = context.getBean("myInnova",Car.class);
		System.out.println(myCar7.specification());
		
		System.out.println("--------------------------------------------");
		
		Car myCar8 = context.getBean("seltos",Car.class);
		System.out.println(myCar8.specification());
		
		System.out.println("--------------------------------------------");
		
		Car myCar9 = context.getBean("compass",Car.class);
		System.out.println(myCar9.specification());
		context.close();
	}
}
