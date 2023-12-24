package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Aspect8 {
	
	/*
	 * The above are wrong Pointcut expressions:-
	 * ``````````````````````````````````````````
	 * @Before("execution(* personal.learning.web.validation.UserRegistrationValidator.validate(..))")
	 * @Before("execution(org.springframework.validation.BindingResult personal.learning.web.validation.UserRegistrationValidator.validate(..))")
	 * @Before("execution(org.springframework.validation.BindingResult validate(..))")
	 * 
	 * Because UserRegistrationValidator object is not stored as Bean in Spring-Context.
	 * 
	 */
	@Before("execution(* validate(..))")
	public void beforeValidation() {
		System.out.println("========> Validate user registration informations <=======");
	}
}
