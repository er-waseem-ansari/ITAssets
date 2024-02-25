package com.hexaware.ITAssets.security;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hexaware.ITAssets.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserDetailsService employeeDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
//		String requestHeader = request.getHeader("Authorization");
//		System.out.println(requestHeader);
//		
//		String username = null;
//		String token = null;
//		
//		if(requestHeader != null && requestHeader.startsWith("Bearer")) {
//			token = requestHeader.substring(7);
//		}
//		
//		try {
//			
//			username = this.jwtService.extractUserName(token);
//			
//		} catch(IllegalArgumentException e) {
//			
//			logger.info("Illegal Argument while fetching the username !!");
//			e.printStackTrace();
//			
//		} catch(ExpiredJwtException e) {
//			
//			logger.info("Given jwt token is expired !! ");
//			e.printStackTrace();
//			
//		} catch(MalformedJwtException e) {
//			
//			logger.info("Some changed has done in token !! Invalid Token ");
//			e.printStackTrace();
//			
//		} catch(Exception e) {
//			
//			e.printStackTrace();
//			
//		}
//		
//		
//		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//			UserDetails userDetails = this.employeeDetailsService.loadUserByUsername(username);
//			Boolean validateToken = this.jwtService.isTokenValid(token, userDetails);
//			
//			if(validateToken) {
//				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				
//				
//				SecurityContextHolder.getContext().setAuthentication(authentication);
//			}
//			else {
//				logger.info("Validation fails!!");
//			}
//		}
//		
//		
//		// Pass request and response to next filter
//		filterChain.doFilter(request, response);
		
		final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        if (authHeader == null || authHeader.isEmpty() ||  !authHeader.startsWith( "Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(7);
        userEmail = jwtService.extractUserName(jwt);
        if (!userEmail.isEmpty()
                && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = employeeDetailsService.loadUserByUsername(userEmail);
            if (jwtService.isTokenValid(jwt, userDetails)) {
                SecurityContext context = SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                context.setAuthentication(authToken);
                SecurityContextHolder.setContext(context);
            }
        }
        filterChain.doFilter(request, response);
		
	
		
	}

}