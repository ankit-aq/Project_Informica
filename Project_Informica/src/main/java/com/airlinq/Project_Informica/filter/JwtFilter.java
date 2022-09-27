package com.airlinq.Project_Informica.filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.airlinq.Project_Informica.service.usercredentials_service.UserCredentialsService;
import com.airlinq.Project_Informica.utility.JwtUtility;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 * This JwtFilter class filters all the requests by the client.
 * It validates the token and filters the request.
 * 
 * @author Ankit Sharma
 * @version 1.0
 *
 */

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private UserCredentialsService userCredentialsService;
    
    /**
     * The doFilterInternal function authorize the request and validates the token.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authorization = httpServletRequest.getHeader("Authorization");
        String token = null;
        String userName = null;
        String password = null;

        if(authorization != null){
            token = authorization;
            userName = jwtUtility.getUsernameFromToken(token);
            password = jwtUtility.getPasswordFromToken(token);
            System.out.println("Huff");
            System.out.println(userName);
            System.out.println(password);
        }

        if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails
                    = userCredentialsService.loadUserByUsername(userName);

            if(jwtUtility.validateToken(token,userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(httpServletRequest)
                );

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}