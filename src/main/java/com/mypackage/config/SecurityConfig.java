package com.mypackage.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((request) -> request
				.requestMatchers("/public/**").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/emp/**").hasRole("EMP")
				.requestMatchers("/marketer/**").hasRole("MARKETER")
				.requestMatchers("/customer/**").hasRole("CUSTOMER")
				.anyRequest()
				.authenticated()
				)
		
				.formLogin(Customizer.withDefaults());
		
		
		return http.build();
	}
	
	@Bean
	UserDetailsService getUserDetailService() {
		
		UserDetails admin = User.builder()
				.username("admin")
				.password(getPasswordEncoder().encode("1234"))
				.roles("ADMIN")
				.build();
		
		UserDetails emp = User.builder()
				.username("emp")
				.password(getPasswordEncoder().encode("1234"))
				.roles("EMP")
				.build();
		
		UserDetails marketer = User.builder()
				.username("marketer")
				.password(getPasswordEncoder().encode("1234"))
				.roles("MARKETER")
				.build();
		
		UserDetails customer = User.builder()
				.username("customer")
				.password(getPasswordEncoder().encode("1234"))
				.roles("CUSTOMER")
				.build();
		
		List<UserDetails> userList = new ArrayList<>();
		userList.add(admin);
		userList.add(emp);
		userList.add(marketer);
		userList.add(customer);
		
		  return new InMemoryUserDetailsManager(userList);	
		 
	}
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		
		return new BCryptPasswordEncoder();
		
		//return NoOpPasswordEncoder.getInstance();
	}
}
