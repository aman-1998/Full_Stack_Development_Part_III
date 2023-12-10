package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Aspect11 {
	
	@Before("execution(* personal.learning.services.*.*(..))")
	public void beforeExecutionMethodsInServiceLayer() {
		System.out.println("===|====|===> Before executing any method in service layer <===|===|===");
	}
}
