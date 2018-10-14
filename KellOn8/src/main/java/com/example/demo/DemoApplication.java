package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@SpringBootApplication
@EnableOAuth2Sso
public class DemoApplication extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.antMatcher("/**")
				.authorizeRequests()
					.antMatchers("/", "/login")
					.permitAll()
				.anyRequest()
					.authenticated()
				.and().logout().logoutSuccessUrl("/").permitAll();
	}
	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}


