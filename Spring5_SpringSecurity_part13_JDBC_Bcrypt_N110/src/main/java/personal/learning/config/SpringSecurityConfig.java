package personal.learning.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
			.usersByUsernameQuery("select username, password, enabled from my_users where username=?")
			.authoritiesByUsernameQuery("select username, authority from my_authorities where username=?");
		
		/*
		 * Tables in Oracle database:-
		 * ---------------------------
		 
		   CREATE TABLE "MY_USERS" (
    			"USERNAME"   VARCHAR2(128),
    			"PASSWORD"   VARCHAR2(128) NOT NULL,
    			"ENABLED"    CHAR(1 BYTE) NOT NULL,
    			CHECK ( enabled IN ('Y','N') ),
    			PRIMARY KEY ( "USERNAME" )
			);
			
			CREATE TABLE "MY_AUTHORITIES" (
    			"USERNAME"    VARCHAR2(128) NOT NULL,
    			"AUTHORITY"   VARCHAR2(128) NOT NULL,
    			CONSTRAINT "MY_AUTHORITIES_UNIQUE" UNIQUE ( "USERNAME","AUTHORITY" ),
    			CONSTRAINT "MY_AUTHORITIES_FK1" FOREIGN KEY ( "USERNAME" )
        			REFERENCES "MY_USERS" ( "USERNAME" )
			);
			
			
			Table MY_USERS:-
			
			USERNAME    PASSWORD                                                       Enabled                                                                                                                      E
			----------- -------------------------------------------------------------- --------
			aman        $2a$10$lz74m/L956k3NIivbAaCyeB.c2cKARo0r0hlkOEsmDpVneGcvzJDC    Y                                                                                                                      Y
			madhav      $2a$10$kj60XzuJykItJ4egNUerw.U8rx2CtMwpwucoXw6I7hAKuKIEaLZ82    Y                                                                                                                     Y
			rakhi       $2a$10$XPzfjC6bpRz6X2AO9Dl8QetGCM8UWFOrgPifs.B1BJj5cdM4HpYN6    Y                                                                                                                     Y
			nitu        $2a$10$mpLpVq0IUya4auZUQN3U4ejt/WaLaGXnk/wqoNIR00SHBjkQtXre2    Y
			
			
			Note:- Here, the passwords used for all users in 'test123'
			
			
			Table MY_AUTHORITIES:-
			
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
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		//return new BCryptPasswordEncoder(7); / strength can vary from 4 to 31
		
		/*
		 * To Store a Password:-
		 * 		1.Generate a long random salt using a CSPRNG.
		 *  	2.Prepend the salt to the password and hash it with a standard password hashing function like Argon2, bcrypt, scrypt, or PBKDF2.
		 *  	3.Save both the salt and the hash in the user's database record.
		 * 
		 *To Validate a Password:-
		 * 		1.Retrieve the user's salt and hash from the database.
		 * 		2.Prepend the salt to the given password and hash it using the same hash function.
		 * 		3.Compare the hash of the given password with the hash from the database. If they match, the password is correct. Otherwise, the password is incorrect.
		 */
		
		/*
		 * Registration:-
		 * ---------------
		 * When we do registration for the first time, at that time the password that we provide is encrypted using
		 * Bcrypt Key-Stretching algorithm. For example, in the above example strength is 7 so, encrypted password
		 * will look like $2a$07$ivyuZG9Z.DheAGfLcBNDGejXgfunLj7lNUJ3WrpjjkLmbLuGgrUkG
		 * In the above encrypted password $2a -> Version, 07 -> Strength, ivyuZG9Z.DheAGfLcBNDGe -> salt, jXgfunLj7lNUJ3WrpjjkLmbLuGgrUkG -> Hashed text
		 * 
		 * 
		 * Login:-
		 * --------
		 * During Login, the provided password is validated. At that time strength and salt will be retrieved from the 
		 * stored encrypted password in database (Note:- 7 will not be considered as strength at that time). For example,
		 * if stored encrypted-password is $2a$10$kj60XzuJykItJ4egNUerw.U8rx2CtMwpwucoXw6I7hAKuKIEaLZ82 , then strength
		 * will be 10 (not 7). Based on strength and salt the password provided during login is encrypted and then matched
		 * against the stored encrypted-password in database. If there is match then we will be logged in otherwise not.
		 */
	}
}
