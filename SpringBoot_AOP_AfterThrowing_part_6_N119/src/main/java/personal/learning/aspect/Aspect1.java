package personal.learning.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Aspect1 {
	
	@AfterThrowing(pointcut = "execution(* testing(*))",
				   throwing = "ex")
	public void afterThrowingExByesting(Throwable ex) {
		System.out.println("=======> The exception thrown is " + ex + " <=======");
	}
}
