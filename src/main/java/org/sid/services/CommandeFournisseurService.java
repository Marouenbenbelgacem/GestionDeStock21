package org.sid.services;

import java.util.List;

import org.sid.dto.CommandeFournisseurDto;

public interface CommandeFournisseurService {
	

	CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);

	CommandeFournisseurDto findById(Integer id);
	CommandeFournisseurDto findByCode (String code);

	List<CommandeFournisseurDto> findAll();
 
	void delete(Integer id);
	

}
