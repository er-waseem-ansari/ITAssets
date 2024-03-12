package com.hexaware.ITAssets.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hexaware.ITAssets.security.JwtAuthenticationFilter;



import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;


@Configuration
@EnableWebSecurity
public class SecurityFilterChainConfiguration {
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private UserDetailsService employeeDetailsService;
	
//	@Bean
//	public UserDetailsService getEmployeeDetailsService() {
//		return new EmployeeDetailsServiceImpl();
//	}
//	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.csrf(AbstractHttpConfigurer::disable)
//	        .cors(AbstractHttpConfigurer::disable)
	                .authorizeHttpRequests((requestMatcher)-> 
					requestMatcher.requestMatchers("/auth/login").permitAll()
					  .requestMatchers("/auth/signup").permitAll()
					  .requestMatchers("/auth/check").hasAuthority("ADMIN")
//					  .requestMatchers("/assets/add").hasAuthority("ADMIN")
					  .requestMatchers("/assets/all").hasAuthority("ADMIN")
					  .anyRequest().permitAll())
	                
	                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	                .authenticationProvider(authenticationProvider()).addFilterBefore(
	                        jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
	                .exceptionHandling(exceptionHandling -> 
	                exceptionHandling.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
	                               ;
	        return http.build();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public AuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(employeeDetailsService);
	        authProvider.setPasswordEncoder(passwordEncoder());
	        return authProvider;
	    }

	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
	            throws Exception {
	        return config.getAuthenticationManager();
	    }
}
