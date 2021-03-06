package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableOAuth2Sso
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .antMatcher("/**")
                .authorizeRequests()
                  .antMatchers("/", "/about", "/help", "/products", "/replySaved", "/statistics", "/sitemap", "/käekell", "/taskukell", "/seinakell", "/spordikell", "/stopper", "/äratuskell", "/static/**")
                  .permitAll()
                .anyRequest()
                  .authenticated()
                .and().logout().logoutSuccessUrl("/").permitAll();

    }
}
