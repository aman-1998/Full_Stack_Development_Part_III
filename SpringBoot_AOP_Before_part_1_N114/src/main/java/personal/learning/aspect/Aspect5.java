package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Aspect5 {
	
	@Before("execution(* getSchoolName())")
	public void beforeFetchingSchoolName() {
		System.out.println("=========> Fetching school Name from DB <=========");
	}
}
