package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class Aspect2 {
	
	@Before("execution(* isNew*(..))")
	public void beforeIsNew() {
		System.out.println("====|====|====> Executed 1st <====|====|====");
	}
}
