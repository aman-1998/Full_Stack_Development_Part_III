package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Aspect2 {
	
	// any method in 'services' package
	@Pointcut("execution(* personal.learning.services.*.*(String))")
	public void forPackageServices() {}
	
	// Any method in 'services' package which are starting with 'get'
	@Pointcut("execution(* personal.learning.services.*.get*())")
	public void forGetter() {}
	
	// Any method in 'services' package which are starting with 'isNew'
	@Pointcut("execution(* personal.learning.services.*.isNew*())")
	public void forIsNew() {}
	
	// Any method in 'services' package which are not starting with 'get' or 'isNew'
	@Pointcut("forPackageServices() && !(forGetter() || forIsNew())")
	public void forPackageServicesNotGetterIsNew() {}
	
	@Before("forPackageServicesNotGetterIsNew()")
	public void beforePackageServicesNotGetterIsNew() {
		System.out.println("===+==+===> Before executing any method in 'services' package which are not starting with 'get' and 'isNew' <==+===+==");
	}
}
