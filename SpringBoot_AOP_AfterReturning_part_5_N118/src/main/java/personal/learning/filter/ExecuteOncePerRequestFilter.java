package personal.learning.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;
/*
 * When request will come to the server-side from client-side. 
 * This filter will intercept the request before it reaches servlets. 
 * And per request it will be executed only once.
 */
public class ExecuteOncePerRequestFilter extends OncePerRequestFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(ExecuteOncePerRequestFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		logger.info("When request will come to the server-side from client-side. "
				+ "This filter will intercept the request before it reaches servlets. "
				+ "And per request it will be executed only once.");
		filterChain.doFilter(request, response);
	}

}
