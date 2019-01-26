package com.wiu.drc.springsecurityconfig;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users=User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(users.username("Angie").password("abcd123").roles("EMPLOYEE","DIRECTOR"))
		.withUser(users.username("Gretchen").password("abcd123").roles("EMPLOYEE","SUPERVISOR"))
		.withUser(users.username("Brandon").password("abcd123").roles("EMPLOYEE","MANAGER"));
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/api/students").hasAnyRole("EMPLOYEE","MANAGER")
		.antMatchers(HttpMethod.GET, "/api/students/**").hasAnyRole("EMPLOYEE","MANAGER")
		.antMatchers(HttpMethod.POST, "/api/students").hasAnyRole("SUPERVISOR", "DIRECTOR")
		.antMatchers(HttpMethod.POST, "/api/students/**").hasAnyRole("SUPERVISOR", "DIRECTOR")
		.antMatchers(HttpMethod.PUT, "/api/students").hasAnyRole("SUPERVISOR", "DIRECTOR")
		.antMatchers(HttpMethod.PUT, "/api/students/**").hasAnyRole("SUPERVISOR", "DIRECTOR")
		.antMatchers(HttpMethod.DELETE, "/api/students/**").hasRole("DIRECTOR")
		.and()
		.httpBasic()
		.and()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	}
	

	
	
}
