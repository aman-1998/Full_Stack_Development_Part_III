package personal.learning.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import personal.learning.model.entity.Users;

@Aspect
public class Aspect1 {
	
	//void org.springframework.validation.beanvalidation.SpringValidatorAdapter.validate(Object,Errors)
	@Before("execution(* validate(..))")
	public void beforeIsNew(JoinPoint joinpoint) {

		MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();
		System.out.println("========> MethodSignature : " + methodSignature + " <========");
		
		Object[] args = joinpoint.getArgs();
		
		for(Object arg : args) {
			System.out.println("=======> Argument : " + arg + " <=======");
		}
	}
	
	@Before("execution(public * test(..))")
	public void beforeTest(JoinPoint joinpoint) {
		MethodSignature methdodSignature = (MethodSignature) joinpoint.getSignature();
		System.out.println("===+===+===> MethodSignature: " + methdodSignature + " <===+===+===");
		
		Object[] args = joinpoint.getArgs();
		
		for(Object arg : args) {
			System.out.println("===+===+===> Argument : " + arg + " <===+===+===");
		}
	}
	
	@Before("execution(public * test2(..))")
	public void beforeTest2(JoinPoint joinpoint) {
		
		Object[] args = joinpoint.getArgs();
		System.out.println("User : " + args[3]);
		
		for(Object arg : args) {
			if(arg instanceof Users) {
				Users user = (Users) arg;
				System.out.println("---------------------------------------------------------------------------------");
				System.out.println("User Information to be saved:-");
				System.out.println("First Name: " + user.getFirstName());
				System.out.println("Last Name: " + user.getLastName());
				System.out.println("Username: " + user.getUserName());
				System.out.println("Email: " + user.getEmail());
				System.out.println("DOB: " + user.getDob());
				System.out.println("Country: " + user.getCountry().getCountryFullName());
				System.out.println("---------------------------------------------------------------------------------");
				break;
			}
		}
	}
}
