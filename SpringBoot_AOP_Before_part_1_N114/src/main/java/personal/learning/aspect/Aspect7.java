package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Aspect7 {
	
	@Before("execution(void save(*))")
	public void beforeCreatingUser() {
		System.out.println("========> Creating user <========");
	}
}
