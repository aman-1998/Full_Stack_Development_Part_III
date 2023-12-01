package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Aspect1 {
	
	@Before("execution(public void save(personal.learning.model.entity.Users))")
	public void beforeServerSideValidation() {
		System.out.println("====> Saving the user in the database <====");
	}
}
