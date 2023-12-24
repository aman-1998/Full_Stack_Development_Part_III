package personal.learning.aspect;

import java.util.List;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Aspect2 {
	
	@AfterReturning(pointcut = "execution(public java.util.List<String> getLanguageList())", 
					returning = "result")
	public void afterReturningLangList(List<String> result) {
		System.out.println("-----------------------------------------------------------");
		System.out.print("Languages : ");
		for(String lang : result) {
			System.out.print(lang + " | ");
		}
		System.out.println("\n-----------------------------------------------------------");
	}
}
