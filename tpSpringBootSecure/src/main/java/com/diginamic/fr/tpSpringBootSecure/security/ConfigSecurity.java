package com.diginamic.fr.tpSpringBootSecure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import com.diginamic.fr.tpSpringBootSecure.dao.AppAuthProvider;
import com.diginamic.fr.tpSpringBootSecure.dao.UserService;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter
{
	@Autowired
	UserService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		// Je fais le lien entre AuthenticationManagerBuilder de SpringBoot Security
		// et mon service UserService
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable().exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint()
		{
		}).and().authenticationProvider(getProvider()).formLogin().loginProcessingUrl("/login").and().logout()
				.logoutUrl("/logout").invalidateHttpSession(true).and().authorizeRequests().antMatchers("/login")
				.permitAll().antMatchers("/logout").permitAll().antMatchers("/user").authenticated().anyRequest()
				.permitAll();
	}

	@Bean
	public AuthentificationProvider getProvider()
	{
		AppAuthProvider provider = new AppAuthProvider();
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
}
