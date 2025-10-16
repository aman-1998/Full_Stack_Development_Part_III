package personal.learning.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import personal.learning.model.dao.UserRepository;
import personal.learning.services.UserServiceImpl;
import personal.learning.web.dto.UserRegistrationDTO;
import personal.learning.web.utility.Constants;

@Aspect
public class UserRegistrationAspect {
	
	//@Autowired
	//private UserRepository userRepository;  // we can use this as well
	
	@Around("execution(* personal.learning.services.UserService+.save(*)) && args(userRegistrationDTO)")
	public void aroundSave(ProceedingJoinPoint pjp, UserRegistrationDTO userRegistrationDTO) throws Throwable {
		
		UserRepository userRepository = ((UserServiceImpl) pjp.getTarget()).getUserRepository();
		String authRequired = userRepository.getAuthRequired(Constants.AUTH_RULE_REGISTRATION);
		
		if(StringUtils.equals(authRequired, Constants.YES)) {
			userRegistrationDTO.setAuthStatus(Constants.AUTH_PENDING);
		}
		pjp.proceed();
	}
}
