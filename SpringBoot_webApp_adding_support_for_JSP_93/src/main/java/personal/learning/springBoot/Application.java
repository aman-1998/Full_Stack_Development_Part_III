package personal.learning.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		/*
		 * 1. Loads the defaults
		 * 2. Starts the boot app
		 * 3. Performs a class-path scan
		 * 4. Starts local tomcat
		 */
	}
}
