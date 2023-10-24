package personal.learning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

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
			.permitAll();
	}
	
}
