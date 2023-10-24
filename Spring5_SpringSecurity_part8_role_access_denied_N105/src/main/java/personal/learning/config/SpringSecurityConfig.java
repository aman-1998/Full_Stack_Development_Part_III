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
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("madhav").password("test123").roles("STUDENT"))
			.withUser(users.username("aman").password("test123").roles("TEACHER"))
			.withUser(users.username("rakhi").password("test123").roles("ADMIN"))
			.withUser(users.username("nitu").password("test123").roles("ADMIN", "TEACHER"));
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		
		/*
		 * 1. Resources from css, js and images folder are allowed and we don't need to authentication for that.
		 * 2. Any url with pattern "/notice/**" and "/holiday/**" can be accessed by users with role "STUDENT", "TEACHER", "ADMIN".
		 * 	  But without authentication these urls won't be accessible. And if we click on that url without being authenticated,
		 * 	  we will be redirected to the login-page.
		 * 3. Any url with pattern "/performance" can be accessed by users with role "TEACHER"
		 * 4. Any url with pattern "/pendingFees" can be accessed by users with role "ADMIN"
		 * 5. Any url for which there is some role assigned, if we try to access that url without logging in then we will be redirected to the login page.
		 * 	  After logging in successfully we will either be directly redirected to the page that we tried to access earlier or to the Access-Denied Page depending on the role of the logged in user. But if we click on "Login" button from any page, we
		 *    will be redirected to login page and after logging in successfully we will be redirected to "/" url or the url specified in 
		 *    MySpringMvcDispatcherServletInitializer class under method getServletMappings().
		 * 6. After logout we will be redirected to login page (This is the default behavior). In the login page here we have a Home button.
		 * 7. As a logged in user if we try to access any url which is meant to be used by a user with different role then we will be redirected to the Access-Denied page.
		 * 
		 * Note:- The behaviors mentioned here are default.
		 */
		
		http.authorizeRequests()
		
			.antMatchers("/notice/**", "/holiday/**").hasAnyRole("STUDENT", "TEACHER", "ADMIN")
			// or // .antMatchers("/notice/**", "/holiday/**").authenticated() // This means to access these urls user must login successfully. And as we have only 3 roles so, either of the lines(48 or 49) will give same result.
			
			.antMatchers("/performance/**").hasRole("TEACHER")
			.antMatchers("/pendingFees/**").hasRole("ADMIN")
			.and()
			.formLogin()
			.loginPage("/myLogin") //GET
			.loginProcessingUrl("/authenticateUser") // POST
			.permitAll()
			.and()
			.logout()
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/accessDenied");
	}
}
