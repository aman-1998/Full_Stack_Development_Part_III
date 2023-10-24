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
			.withUser(users.username("aman").password("test123").roles("EMPLOYEE","MANAGER"))
			.withUser(users.username("rakhi").password("test123").roles("EMPLOYEE","ADMIN"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests() // Restrict access based on HttpServletRequest
			.antMatchers("/additional/css/**", "/additional/js/**", "/additional/images/**")
			.permitAll()
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasAnyRole("CEO", "CTO", "DIRECTOR", "MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.anyRequest() // Any request
			.authenticated() // Specify that URLs are allowed by any authenticated user
			/*
			 * If we don't write above two lines (37 & 38) then /about url won't be restricted
			 * because according to the configuration we don't need any role to access /about url.
			 * Hence, /about url is accessible without login iff line no. 37 & 38 would not have been there.
			 * For example:- You delete line number 37 & 38. Then after starting the web-app, go to /about url.
			 * You will be able to access the page without login.
			 * 
			 * We need line no. 32 & 33 because springSecurity will authenticate all urls (because of line no. 37 & 38).
			 * So, if we will not write line no. 32 & 33 resources from css, js and images folder will also be authenticated which we don't want.
			 * If we don't write line no. 37 & 38, then line no. 32 & 33 are also not required.
			 */
			.and()
			.formLogin() // customize login process
			.loginPage("/customLoginForm") // login page url
			.loginProcessingUrl("/authenticateUser") // login details to be submitted to this url. We don't need to write it in controller as SpringSecurity will take care of it
			.permitAll()
			.and()
			.logout()
			.permitAll();
	}
	
}
