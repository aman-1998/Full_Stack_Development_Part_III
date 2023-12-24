package personal.learning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import personal.learning.config.auth.provider.CustomAuthenticationProvider;
import personal.learning.filter.ExecuteOncePerRequestFilter;
import personal.learning.filter.LoggedInUserInformationFilter;
import personal.learning.filter.LoginProcessFilter;
import personal.learning.filter.RequestValidationFilter;
import personal.learning.services.UserService;
import personal.learning.web.utility.Constants;

@Configuration
@EnableWebSecurity
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	 * Custom Authentication Provider is required if you want to add some extra functionalities
	 * other than username & password for authentication for eg. OTP, CAPTCHA, etc
	 */
	@Bean
	public CustomAuthenticationProvider authenticationProvider() {
		CustomAuthenticationProvider authProvider = new CustomAuthenticationProvider();
		authProvider.setUserDetailsService(userService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
		authManagerBuilder.authenticationProvider(authenticationProvider());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(new RequestValidationFilter(), UsernamePasswordAuthenticationFilter.class) // RequestValidationFilter will be executed before UsernamePasswordAuthenticationFilter
			.addFilterAt(new LoginProcessFilter(), UsernamePasswordAuthenticationFilter.class) // LoginProcessFilter and UsernamePasswordAuthenticationFilter can be executed randomly at this position i.e., either LoginProcessFilter will be executed before UsernamePasswordAuthenticationFilter or viceversa.
			.addFilterAfter(new LoggedInUserInformationFilter(), UsernamePasswordAuthenticationFilter.class) // LoggedInUserInformationFilter will be executed after UsernamePasswordAuthenticationFilter
			.addFilterAfter(new ExecuteOncePerRequestFilter(), UsernamePasswordAuthenticationFilter.class) // ExecuteOncePerRequestFilter will be executed only once per request after UsernamePasswordAuthenticationFilter
			.authorizeRequests()
			.antMatchers("/notice/**", "/holiday/**").authenticated()
			.antMatchers("/performance/**").hasAuthority(Constants.ROLE_TEACHER)
			.antMatchers("/pendingFees/**").hasAuthority(Constants.ROLE_ADMIN)
			.and()
			.formLogin()
			.loginPage("/myLogin")
			.loginProcessingUrl("/authenticateUser")
			.permitAll()
			.and()
			.logout()
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/accessDenied");
	}
	
}
