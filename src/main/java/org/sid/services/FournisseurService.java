package org.sid.services;

import java.util.List;

import org.sid.dto.FournisseurDto;

public interface FournisseurService {

	FournisseurDto save(FournisseurDto fournisseurDto);

	FournisseurDto findById(Integer id);

	List<FournisseurDto> findAll();

	void delete(Integer id);

}
