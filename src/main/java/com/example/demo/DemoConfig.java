package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoConfig {

	@Bean
	public InMemoryUserDetailsManager userDetails() {
		UserDetails mary = User.builder()
							.username("mary")
							.password("{noop}mary123")
							.roles("EMPLOYEE")
							.build();
		
		return new InMemoryUserDetailsManager(mary);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(configurer ->
				configurer.anyRequest().authenticated())).formLogin(
						form -> form.loginPage("/showMyLoginPage")
						.loginProcessingUrl("/authenticateTheUser")
						.permitAll()
						).logout(logout -> logout.permitAll());
						
			return http.build();
	}
}
