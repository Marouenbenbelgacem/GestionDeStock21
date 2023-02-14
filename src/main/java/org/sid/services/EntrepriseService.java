package org.sid.services;

import java.util.List;

import org.sid.dto.EntrepriseDto;

public interface EntrepriseService {

	EntrepriseDto save(EntrepriseDto entrepriseDto);

	EntrepriseDto findById(Integer id);

	List<EntrepriseDto> findAll();

	void delete(Integer id);

}
