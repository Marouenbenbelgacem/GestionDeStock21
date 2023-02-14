package org.sid.services.auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.sid.dto.UtlisateursDto;
import org.sid.exception.EntityNotFoundException;
import org.sid.exception.ErrorCodes;
import org.sid.model.Utlisateurs;
import org.sid.repository.UtlisateurRepository;
import org.sid.services.UtlisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.sid.model.auth.ExtendedUser;


@Service
public class ApplicationUserDetailsService implements UserDetailsService {

	@Autowired
	private UtlisateurService utlisateurService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { // chercher l'utlisateur par
																							// son uer name
		UtlisateursDto utlisateur = utlisateurService.findByEmail(email);
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		utlisateur.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
		return new ExtendedUser(utlisateur.getEmail(),utlisateur
				.getMotDePass(),utlisateur
				.getEntreprise()
				.getId(),authorities);

	}
}
