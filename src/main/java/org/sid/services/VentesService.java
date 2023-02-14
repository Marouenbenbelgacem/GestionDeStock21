package org.sid.services;

import java.util.List;

import org.sid.dto.VentesDto;

public interface VentesService {

	
	VentesDto save(VentesDto ventesDto);

	VentesDto findById(Integer id);
	VentesDto findByCode (String code);

	List<VentesDto> findAll();
 
	void delete(Integer id);
}
