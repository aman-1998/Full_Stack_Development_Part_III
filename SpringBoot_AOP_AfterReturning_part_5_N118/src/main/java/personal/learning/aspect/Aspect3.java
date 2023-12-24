package personal.learning.aspect;

import java.util.LinkedHashMap;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Aspect3 {
	
	@AfterReturning(pointcut = "execution(public java.util.LinkedHashMap<String, String> getCountryMap())",
					returning = "countryMap")
	public void afterReturningCountryList(LinkedHashMap<String, String> countryMap) {
		System.out.println("===+===+===>>> Country Map : " + countryMap + " <<<===+===+===");
		
		countryMap.remove("CHI");
		countryMap.remove("FIN");
		countryMap.put("GER", "Germany");
		/*
		 * Now in the registration form, China and Finland will not be available 
		 * for selection in the dropdown, instead Germany will be added.
		 */
	}
}
