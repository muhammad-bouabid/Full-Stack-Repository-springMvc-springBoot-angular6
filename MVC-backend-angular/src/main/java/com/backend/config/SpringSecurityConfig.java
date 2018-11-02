package com.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author m.BOUABID
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	/**
	 * 
	 * Kind of links provided based on the User authoroties USER - SUPER_USER - SIMPLE_USER ..etc
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/scenarios/**").permitAll()
		.antMatchers("/phones/**","/plages/**").access("hasRole('ADMIN')")
		.antMatchers("/files/**").access("hasRole('USER')")
		.and().httpBasic().authenticationEntryPoint(authEntryPoint);
	}

	/**
	 * Build Authentication and attach it to the appContext
	 * 
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(this.passwordEncoder());
		auth.userDetailsService(userDetailsService);
	}
	
	/**
	 * Password Encrypter Bean
	 */
//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
//		return encoder;
//	}
}
