package com.example.LoanApplication.config;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.LoanApplication.services.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		http.csrf().disable().cors().disable().authorizeRequests()
//		.antMatchers("/generate-token","/customer/").permitAll().antMatchers(HttpMethod.OPTIONS)
//		.permitAll().anyRequest().authenticated().and().exceptionHandling()
//		.authenticationEntryPoint(unauthorizedHandler).and().sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.csrf().disable().authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/customers/**").hasAnyRole("CUSTOMER", "ADMIN")
		.antMatchers("/authenticate", "/authorize", "/**")
		.permitAll()
		.antMatchers(HttpMethod.OPTIONS)
		.permitAll().anyRequest().authenticated().and().exceptionHandling()
		.authenticationEntryPoint(unauthorizedHandler)
		.and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
//	    http.csrf().disable().authorizeRequests()           
//        .antMatchers("/generate-token").permitAll()
//        .antMatchers("/admin").permitAll()
//        .antMatchers("/customers").permitAll()
//        .anyRequest().authenticated()
//        .and().exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//        .and().formLogin().loginPage("/login").loginProcessingUrl("/login")
//        .defaultSuccessUrl("/index.html").failureUrl("/login?error")
//        .and().logout().logoutUrl("/logout");

		
		http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
	}
}
