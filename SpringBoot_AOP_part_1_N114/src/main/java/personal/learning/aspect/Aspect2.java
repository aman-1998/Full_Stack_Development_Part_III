package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Aspect2 {
	
	@Before("execution(public java.util.List<personal.learning.model.entity.Country> getCountryList())")
	public void beforeFetchingCountriesFromDB() {
		System.out.println("=======> Fetching list of countries from DB to validate country <========");
	}
}
