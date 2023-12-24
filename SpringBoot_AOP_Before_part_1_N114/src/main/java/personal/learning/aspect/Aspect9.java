package personal.learning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Aspect9 {
	
	@Before("execution(* personal.learning.model.dao.UserRepository.getUserByUserName(..))")
	public void beforeSettingDateOfBirth() {
		System.out.println("========> Getting User information by using unique username <========");
	}
}
