package org.sid.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import static org.sid.utils.Constants.AUTHENTIFICATION_ENDPONT;
import org.sid.dto.auth.AuthentificationRequest;
import org.sid.dto.auth.AuthentificationResponse;
import org.sid.model.auth.ExtendedUser;
import org.sid.services.auth.ApplicationUserDetailsService;
import org.sid.utils.JwtUtil;

@RestController
@RequestMapping(AUTHENTIFICATION_ENDPONT)
public class AuthenticationController {
	
	@Autowired(required=true)
	private JwtUtil jwtUtil; 

	@Autowired
	private ApplicationUserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthentificationResponse> authenticate(@RequestBody AuthentificationRequest request) {

		authenticationManager.authenticate(

				new UsernamePasswordAuthenticationToken(
						request.getLogin(),
						request.getPassword()));

		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
		final String jwt =  jwtUtil.generateToken((ExtendedUser) userDetails);
		return ResponseEntity.ok(AuthentificationResponse.builder().accessToken("Dummy Access Roken").build());
	}

}
