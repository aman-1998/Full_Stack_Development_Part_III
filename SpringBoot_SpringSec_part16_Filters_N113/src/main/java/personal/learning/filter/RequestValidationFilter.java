package personal.learning.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
/*
 * addFilterBefore : This type of filter can be used to validate request before it reaches the servlets
 */
public class RequestValidationFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestValidationFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String username = req.getParameter("username");
		try {
			if(StringUtils.equals(username, "admin") 
								|| StringUtils.equals(username, "master")) {
				request.setAttribute("reservedUsername", "true");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/loginPage.jsp");
				dispatcher.forward( request, response );
				logger.debug("Username " + username + " can't be used for login");
				throw new BadCredentialsException("Reserved username can't be used for login");
			} else {
				chain.doFilter(request, response);
			}
		} catch(BadCredentialsException ex) {
			ex.printStackTrace();
		}
	}
	
}
