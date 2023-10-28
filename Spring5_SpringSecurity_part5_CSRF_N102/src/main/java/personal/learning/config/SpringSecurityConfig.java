package personal.learning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/*
 * For Monolithic applications (in which Model, Controller and View are in same application)
 * ------------------------------------------------------------------------------------------
 * After successful authentication the server side of the app generates CSRF token and that token is available for the framework.
 * Now from the view (jsp) we send CSRF as parameter with each request. Server then validates the CSRF token that was initially generated
 * after successful authentication and the token that is received with the request. For Monolithic apps Spring Security's default CSRF
 * protection is solves the problem.
 * Note: We send CSRF from jsp page using <input/> type 'hidden'. Or if we use Form element then "Hidden input type" is automatically added.
 * 
 * 
 * 
 * -----------------X---------------------X--------------------X------------------------X---------------------------X-----------------------X----------------------
 * 
 * 
 * 
 * For applications in which Backend-application (Model & Controller) and Frontend-application (View) are communicating with each other. Eg. Angular for frontend
 * --------------------------------------------------------------------------------------------------------------------------------------------------------------
 * After After successful authentication, the Backend app will generate CSRF token which will be available as request attribute. 
 * Now we need to send this CSRF token as header of the response. At this time Spring Security will automatically stores CSRF token
 * in the cookie. Now in the frontend side we extract the CSRF token from cookie and store it in the SessionStorage for subsequent
 * request. So, now for every request we get the CSRF from SessionStorage and send the CSRF token as header of the request.
 * This CSRF token will then be validated against the one that was generated initially.
 * 
 * Note: With each request cookie also goes along with that but Backend application will only try to get CSRF from 
 * request Header or parameter. This is very important to understand. Let us understand with example:-
 * When user clicks on an evil link, a url is fired (let's assume the url is valid). Now along with the url cookie will also
 * go to the backend. But our backend app won't care about CSRF in cookie. It will look for CSRF token in the header or parameter of the request.
 * So, our application won't be compromized. 
 * So, the evil website will have to read the CSRF which is in the cookie but since the evil website has different domain, it can't read
 * cookie from other site. Hence, our application will be protected from CSRF attack.
 * 
 */

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// Add users for in memory authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("madhav").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("aman").password("test123").roles("MANAGER"))
			.withUser(users.username("rakhi").password("test123").roles("ADMIN"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests() // Restrict access based on HttpServletRequest
			.antMatchers("/additional/css/**", "/additional/js/**", "/additional/images/**")
			.permitAll()
			.anyRequest() // Any request
			.authenticated() // Authenticate all requests
			.and()
			.formLogin() // customize login process
			.loginPage("/customLoginForm") // login page url
			.loginProcessingUrl("/authenticateUser") // login details to be submitted to this url. We don't need to write it in controller as SpringSecurity wil take care of it
			.permitAll()
			.and()
			.logout()
			.permitAll();
	}
	
}
