package personal.learning.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username, password, enabled from users where username=?")
			.authoritiesByUsernameQuery("select username, authority from authorities where username=?");
		
		/*
		 * Tables in Oracle database:-
		 * ---------------------------
		 
		   CREATE TABLE "USERS" (
    			"USERNAME"   VARCHAR2(128),
    			"PASSWORD"   VARCHAR2(128) NOT NULL,
    			"ENABLED"    CHAR(1 BYTE) NOT NULL,
    			CHECK ( enabled IN ('Y','N') ),
    			PRIMARY KEY ( "USERNAME" )
			);
			
			CREATE TABLE "AUTHORITIES" (
    			"USERNAME"    VARCHAR2(128) NOT NULL,
    			"AUTHORITY"   VARCHAR2(128) NOT NULL,
    			CONSTRAINT "AUTHORITIES_UNIQUE" UNIQUE ( "USERNAME","AUTHORITY" ),
    			CONSTRAINT "AUTHORITIES_FK1" FOREIGN KEY ( "USERNAME" )
        			REFERENCES "USERS" ( "USERNAME" )
			);
			
			
			Table USERS:-
			
			USERNAME    PASSWORD   Enabled                                                                                                                      E
			----------- ---------- --------
			aman        test123    Y                                                                                                                      Y
			madhav      test123    Y                                                                                                                     Y
			rakhi       test123    Y                                                                                                                     Y
			nitu        test123    Y
			
			
			
			Table AUTHORITIES:-
			
			USERNAME     AUTHORITY                                                                                                                       
			----------- --------------
			aman        ROLE_TEACHER                                                                                                                    
			madhav      ROLE_STUDENT                                                                                                                    
			nitu        ROLE_ADMIN                                                                                                                      
			nitu        ROLE_TEACHER                                                                                                                    
			rakhi       ROLE_ADMIN
			
		 */
	}

	/*
	 * Below method can also be used
	 */
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		
//		  auth.jdbcAuthentication().dataSource(dataSource)
//			.usersByUsernameQuery(
//				"select username, password, enabled from users where username=?")
//			.authoritiesByUsernameQuery(
//				"select username, authority from authorities where username=?");
//	}	
	
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
			
			.antMatchers("/notice/**", "/holiday/**").authenticated()
			// or // .antMatchers("/notice/**", "/holiday/**").hasAnyRole("STUDENT", "TEACHER", "ADMIN")
			
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
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
