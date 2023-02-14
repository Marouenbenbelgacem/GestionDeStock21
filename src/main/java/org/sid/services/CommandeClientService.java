package org.sid.services;

import java.util.List;

import org.sid.dto.CommandeClientDto;

public interface CommandeClientService {
	
	CommandeClientDto save(CommandeClientDto commandeClientDto);

	CommandeClientDto findById(Integer id);
	CommandeClientDto findByCode (String code);

	List<CommandeClientDto> findAll();
 
	void delete(Integer id);
	
	
}
