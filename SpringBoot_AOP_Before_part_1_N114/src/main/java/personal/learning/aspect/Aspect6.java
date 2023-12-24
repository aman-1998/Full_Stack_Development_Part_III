package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Aspect6 {
	
	@Before("execution(* getRole*())")
	public void beforeGettingRole() {
		System.out.println("========> Fetching Role releated information <========");
	}
}
