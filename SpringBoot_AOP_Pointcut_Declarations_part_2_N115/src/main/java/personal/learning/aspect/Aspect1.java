package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Aspect1 {
	
	@Pointcut("execution(boolean isNew*(String))")
	public void forIsNew() {}
	
	@Before("forIsNew()")
	public void beforeIsNew() {
		System.out.println("=======> Before checking if the user is a new user  <======");
	}
}
