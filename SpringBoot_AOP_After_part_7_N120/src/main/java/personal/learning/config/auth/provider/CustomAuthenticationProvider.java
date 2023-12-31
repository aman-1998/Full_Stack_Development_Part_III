package personal.learning.config.auth.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * Custom Authentication Provider is required if you want to add some extra functionalities
 * other than username & password for authentication for eg. OTP, CAPTCHA, etc
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	private UserDetailsService userDetailsService;
	
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
		UserDetails loadedUserDetails = this.getUserDetailsService().loadUserByUsername(username);
		if (loadedUserDetails == null) {
			throw new InternalAuthenticationServiceException("Bad credentials");
		}
		if(authentication.getCredentials() == null) {
			throw new BadCredentialsException("Bad credentials");
		}
		String storedPassword = loadedUserDetails.getPassword();
		String presentedPassword = authentication.getCredentials().toString();
		if(!this.passwordEncoder.matches(presentedPassword, storedPassword)) {
			throw new BadCredentialsException("Invalid password");
		}
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.addAll(loadedUserDetails.getAuthorities());
		Object principal = loadedUserDetails;
		return new UsernamePasswordAuthenticationToken(principal, presentedPassword, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
}
