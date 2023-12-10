package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Aspect10 {
	
	@Before("execution(* personal.learning.services.SchoolServiceImpl.*(..))")
	public void beforeExecutingSchoolServiceMethods() {
		System.out.println("=+==+===+===> Before executing every method in SchoolServiceImpl <==+===+===+==");
	}
}
