package com.hm.ecom.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hm.ecom.model.AuthenticationRequest;
import com.hm.ecom.model.AuthenticationResponse;
import com.hm.ecom.service.MyUserDetailService;
import com.hm.ecom.util.JwtUtil;

@RestController
public class HelloResource {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailService userDetailsService; 
	
	@Autowired
	private JwtUtil jwtTokenUtils;
	
	@RequestMapping("/hello")
	public String hello() { return "Hello";}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
			try {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
						);
			} catch (BadCredentialsException e) {
				throw new Exception("Incorrect user",e);
			}
			
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			
			final String jwt = jwtTokenUtils.generateToken(userDetails);
			
			return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
