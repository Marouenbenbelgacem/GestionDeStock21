package org.sid.services;

import java.util.List;

import org.sid.dto.UtlisateursDto;

public interface UtlisateurService {

	UtlisateursDto save(UtlisateursDto utlisateurDto);

	UtlisateursDto findById(Integer id);

	List<UtlisateursDto> findAll();

	void delete(Integer id);
	
	UtlisateursDto findByEmail(String email);

}
