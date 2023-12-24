package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class Aspect1 {
	
	@Before("execution(boolean isNew*(*))")
	public void beforeIsNew() {
		System.out.println("========> Executed 2nd <========");
	}
}
