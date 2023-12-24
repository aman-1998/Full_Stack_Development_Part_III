package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Aspect4 {
	
	//@Before("execution(* get*Map())") // Wrong Pointcut expression
	//@Before("execution(* * getMap*())") // Wrong Pointcut expression
	@Before("execution(public * getLang*())")
	public void beforeGettingLang() {
		System.out.println("========> Fetching laguage related information <========");
	}
}
