package personal.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
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
