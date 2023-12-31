package personal.learning.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * addFilterAt : This type of filter is used to to log informations like "Authentication is in progress"
 */
public class LoginProcessFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginProcessFilter.class);
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		logger.info("Authentication is in progress");
		chain.doFilter(request, response);
	}
}
