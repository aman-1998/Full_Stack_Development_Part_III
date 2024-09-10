package personal.learning.aspect;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import personal.learning.model.dao.UserRepository;
import personal.learning.model.entity.Role;
import personal.learning.services.UserServiceImpl;
import personal.learning.web.dto.UserRegistrationDTO;
import personal.learning.web.utility.Constants;

@Aspect
public class UserRegistrationAspect {
	
	@Around("execution(* personal.learning.services.UserService+.save(*)) && @target(personal.learning.custom.annotation.Authorizable) && args(userRegistrationDTO)")
	public void aroundSave(ProceedingJoinPoint pjp, UserRegistrationDTO userRegistrationDTO) throws Throwable {
		
		UserRepository userRepository = ((UserServiceImpl) pjp.getTarget()).getUserRepository();
		String authRequired = userRepository.getAuthRequired(Constants.AUTH_RULE_REGISTRATION);
		
		if(StringUtils.equals(authRequired, Constants.YES)) {
			userRegistrationDTO.setAuthStatus(Constants.AUTH_PENDING);
		}
		pjp.proceed();
	}
}
