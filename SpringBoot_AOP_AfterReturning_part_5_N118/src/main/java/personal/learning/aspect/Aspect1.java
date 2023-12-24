package personal.learning.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Aspect1 {
	
	@AfterReturning("execution(public java.util.LinkedHashMap<String, String> getRoleMap())")
	public void afterReturningRoleList() {
		System.out.println("=======> Executed after getting Role Map <=======");
	}
}
