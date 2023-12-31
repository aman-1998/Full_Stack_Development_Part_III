package personal.learning.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Aspect1 {
	
	@Around("execution(* testing2())")
	public void aroundTesting2(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("======> Around advice started for testing2 <=====");
		
		long begin = System.currentTimeMillis();
		proceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		System.out.println("======> Time taken to execute testing2 : " + duration/1000 + " sec <=====");
	}
	
	@Around("execution(* testing1(*))")
	public void aroundTesting1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("===+==+===> Around advice started for testing1 <===+==+===");
		
		long start = System.currentTimeMillis();
		proceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();
		
		long duration = end - start;
		
		System.out.println("======> Time taken to execute testing1 : " + duration/1000 + " sec <=====");
	}
	
	@Around("execution(public * testing3(*))")
	public Object aroundTesting3(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("===^==^===> Around advice started for testing3 <===^==^===");
		
		long start = System.currentTimeMillis();
		Object result;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			result = "~~~~~~~>  We quitely digested exception in testing3 <~~~~~~~";
		}
		long end = System.currentTimeMillis();
		
		long duration = end - start;
		System.out.println("==^===^===> Time taken to execute testin3 : " + duration/1000 + " sec <===^===^==");
		
		return result;
	}
}
