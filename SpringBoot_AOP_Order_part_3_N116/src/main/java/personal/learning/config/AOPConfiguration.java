package personal.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import personal.learning.aspect.Aspect1;
import personal.learning.aspect.Aspect2;

/*
 * Advantages of AOP:-
 * -------------------
 * 1. Code reusability. Write once and use multiple times
 * 2. Much better than being scattered everywhere.
 * 3. Reduces code complexity
 * 4. Based on configuration, apply aspects selectively to different parts of the app.
 * 5. No need to make changes to main application code --- Very Important
 * --------------------------------------------------------
 * 
 * Usecase:-
 * ----------
 * 1. Most common - Logging, Security, Transactions
 * 2. Audit Logging - Who, What, When, Where
 * 3. Exception Handling and notify DevOps team via Email/SMS
 * 4. API Management - How many times a methods been call by a user
 * 5. Analytics - What are peak times ? , What is average load ? , who is top user ?
 * 
 * Disadvantage:-
 * --------------
 * 1. Too many aspects make app flow hard to follow. So, we should always be 
 *    careful and make use of aspects when it is really required.
 * 2. There is minor performance cost for aspect execution (as Spring AOP uses run-time-weaving).
 * 
 * AOP Terminology:-
 * -----------------
 * 1. Cross-Cutting - Cutting the execution from middle of the code and giving the control to some other part of the code.
 * 2. Aspect - Module of code for cross-cutting-concerns (cross-cutting-logic)
 * 3. Advice - What action is taken and when it should be applied.
 * 4. Join Point - When to apply code during program execution.
 * 5. Pointcut - A predicate expression for where advice should be applied.
 * 6. Weaving - Connecting Aspects to target objects to create an advised object. Spring AOP uses run-time weaving
 * 	  Different Types of Object:-
 * 	  	1. Compile-Time
 * 		2. Load-Time
 * 		3. Run-Time - It is slowest of all
 * 
 * Advice Types:-
 * --------------
 * 1. Before Advice (@Before) - Run before the method
 * 2. After finally Advice (@After) - Run after the method (finally)
 * 3. After returning advice (@AfterReturning) - Run after the method (after successful execution)
 * 4. After throwing advice (@AfterThrowing) - Run after exception is thrown inside the method
 * 5. Around Advice (@Around) - Run before and after the method
 * 
 * AspectJ vs Spring AOP:-
 * -----------------------
 * AspectJ:-
 * ---------
 * -> It's the original AOP framework released in 2001.
 * -> Provides complete support of AOP
 * -> Rich support for join points: method-level, constructor-level, field-level
 * -> Code weaving: compile-time, post-compile-time, load-time
 * -> Can apply aspects with any POJO not just beans from Spring app context
 * -> Faster performance compared to Spring AOP
 * -> AspectJ pointcut syntax can become complex
 * 
 * Spring AOP:-
 * ------------
 * -> Simpler to use than AspectJ
 * -> Uses Proxy Pattern
 * -> Can migrate to AspectJ when using @Aspect annotation
 * -> Supports only method-level join point
 * -> Can apply aspects only to beans created by Spring app context
 * -> Minor performance cost for aspect execution
 * -> It is light implementation of AOP
 * -> Solves common problems in Enterprise Application
 * -> So, we should start with Spring AOP. And if we have complex requirement then we should move to AspectJ
 * -> Spring AOP uses some AspectJ annotations and AspectJ classes
 * 
 * ---------------------------------------------------------------------------------------------------------------------
 * Note:-
 * ```````
 * Spring AOP currently supports only method execution join points (advising the execution of methods on Spring beans).
 * ---------------------------------------------------------------------------------------------------------------------
 * Spring AOP uses AspectJ's pointcut expression language. There are
 * various types of pointcut expressions. We are starting with
 * execution pointcuts which applies to execution of methods.
 * 
 * Syntax:-
 * ~~~~~~~~
 * execution(modifiers-pattern?  return-type-pattern  declaring-type-pattern?  
 * 			   method-type-pattern(param-pattern) throws-pattern)
 * 
 * ? - Optional
 * * - Wildcard (Matches on everything)
 * 
 * Examples:-
 * ~~~~~~~~~~
 * @Before("execution(public void personal.learning.dao.AccountDao.addAccount())")
 * @Before("execution(public java.util.List<personal.learning.model.entity.Country> getCountryList())")
 * @Before("execution(public void addAccount())")
 * @Before("execution(public void add*())")
 * @Before("execution(public boolean isNew*(String))")
 * @Before("execution(public * getLang*())")
 * @Before("execution(* add*())")
 * 
 * 
 * Note:-
 * ``````
 * @Before("execution(* * geLangtMap())") // Wrong Pointcut expression. Because modifiers-pattern is optional so there is no need to specify wildcard(*) for it.
 * @Before("execution(* get*Map())") // Wrong Pointcut expression. Because wildcard(*) can't be applied in the middle of method name.
 * 
 * 
 * 
 * For param-pattern:-
 * ~~~~~~~~~~~~~~~~~~~
 * () - Matches a method with no argument
 * (*) - Matches a method with one argument of any type
 * (..) - Matches a method with 0 or more arguments of any type
 * 
 * Examples:-
 * ~~~~~~~~~~
 * @Before("execution(public void save(personal.learning.model.entity.Users))")
 * @Before("execution(* addAccount())")
 * @Before("execution(* addAccount(personal.learning.entity.Account))")
 * @Before("execution(public void addAccount(*))")
 * @Before("execution(* personal.learning.dao.AccountDao.addAccount(..))")
 * @Before("execution(* personal.learning.dao.*.*(..))")
 * 
 * 
 * ---------------------------------------------------------------------------------------
 * 
 * Pointcut Declaration:-
 * ~~~~~~~~~~~~~~~~~~~~~~
 * 
 * @Pointcut("execution(* personal.learning.dao.*.*(..))")
 * public void forDaoPackage() {}
 * 
 * We can combine two or more pointcuts using:-
 * ```````````````````````````````````````````
 * 1. && - AND
 * 2. || - OR
 * 3. !  - NOT
 * 
 * ---------------------------------------------------------------------------------------
 * 
 * Aspect Ordering:-
 * ````````````````
 * 
 * @Before("execution(boolean isNew*(*))")    -----> @Order(2)
 * public void method1() {
 * 		Syso("MurMurmurmur");
 * }
 * 
 * @Before("execution(* isNew*(..))")    ------> @Order(1)
 * public void method2() {
 * 		Syso("BlaBalhBlah");
 * }
 * 
 * public boolean isNewEmail(String emailId) ===> This method is matching with both pointcut expressions above. But when 
 * this method will be called then method2 will be executed first and then method1 will be executed because of ordering.
 * 
 * -----------------------------------------------------------------------------------------
 * 
 */

@Configuration
@EnableAspectJAutoProxy
public class AOPConfiguration {
	
	@Bean
	public Aspect1 aspect1() {
		return new Aspect1();
	}
	
	@Bean
	public Aspect2 aspect2() {
		return new Aspect2();
	}
	
}
