package personal.learning.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
/*
 * addFilterAfter : This type of filter is used:-
 * 1. To send user an email containing information about logged in user, login time etc
 * 2. To log information of logged in user, etc
 */
public class LoggedInUserInformationFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggedInUserInformationFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null) {
			logger.info("User " + authentication.getName() + " is successfully "
					+ "authenticated and has authorities " + authentication.getAuthorities().toString());
//			System.out.println("User " + authentication.getName() + " is successfully "
//					+ "authenticated and has authorities " + authentication.getAuthorities().toString());
		}
		chain.doFilter(request, response);
		
	}
	
}
