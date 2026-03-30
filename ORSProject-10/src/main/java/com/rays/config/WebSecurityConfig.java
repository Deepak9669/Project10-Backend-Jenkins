package com.rays.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * WebSecurityConfig is used to configure Spring Security for the application.
 * 
 * It defines: - URL authorization rules - Stateless session policy (JWT आधारित
 * authentication) - Custom JWT filter integration
 * 
 * It also enables method-level security using annotations like @PreAuthorize.
 * 
 * @author Deepak Verma
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Custom JWT filter to validate token in each request
	 */
	@Autowired
	private JWTRequestFilter jwtRequestFilter;

	/**
	 * Configures HTTP security rules
	 * 
	 * @param http HttpSecurity object
	 * @throws Exception in case of error
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()

				// Configure URL authorization
				.authorizeRequests().antMatchers("/Auth/**", "/User/profilePic/**").permitAll().anyRequest()
				.authenticated()

				// Disable session (stateless JWT authentication)
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add JWT filter before Spring Security authentication filter
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

		// Enable CORS
		http.cors();
	}
}