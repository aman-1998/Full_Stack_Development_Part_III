package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Aspect3 {
	
	@Before("execution(public boolean isNew*(String))")
	public void beforeCheckingNewEmailAndUsername() {
		System.out.println("========> Checking whether the user is registering for the first time <========");
	}
}
