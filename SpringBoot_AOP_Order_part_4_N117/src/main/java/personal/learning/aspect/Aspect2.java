package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class Aspect2 {
	
	@Before("execution(* getLanguageList())")
	public void beforeIsNew() {
		System.out.println("====|====|====> Executed Lang <====|====|====");
	}
}
