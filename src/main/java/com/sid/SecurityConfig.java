package com.sid;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().withUser("soukaina").password("{noop}1234").roles("RESPONSABLE");
	auth.inMemoryAuthentication().withUser("chaymae").password("{noop}0000").roles("SECRETAIRE");}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
	    .authorizeRequests()
	                        .anyRequest()
	                                      .authenticated()
	                                              .and()
	                                                    .formLogin()
	                                                              .loginPage("/login")
	                                                                          .permitAll()
	                                                                             .defaultSuccessUrl("/Acceuil")
	                                                                             .and()
	                                                                             .logout()
	                                                                             .permitAll()
	                                                                             .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	                                                                             .logoutSuccessUrl("/login");
	
	
	
}


}

