package com.airlinq.Project_Informica.service.authenticate_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.airlinq.Project_Informica.exception.UnauthorizedAccessException;
import com.airlinq.Project_Informica.model.JwtRequest;
import com.airlinq.Project_Informica.model.JwtResponse;
import com.airlinq.Project_Informica.service.usercredentials_service.UserCredentialsService;
import com.airlinq.Project_Informica.utility.JwtUtility;

@Service
public class AuthenticateServiceImpl implements AuthenticateService{

	private String userRoleName;
		
	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
		
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserCredentialsService userCredentialsService;
	
	/**
	 * This authenticate function authenticate the requests and the credentials and return the token.
	 */
	@Override
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

		System.out.println(this.bCryptPasswordEncoder.encode(jwtRequest.getPassword()));	
		
		try {

			authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(
								jwtRequest.getUsername(), 
								jwtRequest.getPassword()
						)
			);
			
		}
		catch (BadCredentialsException e) {
			throw new UnauthorizedAccessException("Invalid_CREDENTIALS");
		}
		
		userRoleName = userCredentialsService.usernameRole(jwtRequest.getUsername(), jwtRequest.getRoleName());
				
		final UserDetails userDetails
				= userCredentialsService.loadUserData(userRoleName);
		
		final String token
				= jwtUtility.generateToken(userDetails);
		
		
		return new JwtResponse(token);
		
	}

}
