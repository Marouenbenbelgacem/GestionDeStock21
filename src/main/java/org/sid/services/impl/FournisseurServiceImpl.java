package org.sid.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.sid.dto.FournisseurDto;
import org.sid.exception.EntityNotFoundException;
import org.sid.exception.ErrorCodes;
import org.sid.exception.InvalidEntityException;
import org.sid.repository.FournisseurRepository;
import org.sid.services.FournisseurService;
import org.sid.validator.FournisseurValidator;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
	public FournisseurRepository fournisseurRepository;

	public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
		this.fournisseurRepository = fournisseurRepository;
	}

	@Override
	public FournisseurDto save(FournisseurDto fournisseurDto) {
		List<String> errors = FournisseurValidator.validate(fournisseurDto);
		if (!errors.isEmpty()) {
			log.error("Fournisseur is nor valid");
			throw new InvalidEntityException("Fournisseur n'est pas valid", ErrorCodes.FOURNISSEUR_NOT_VALID, errors);
		}

		return FournisseurDto.fromEntity(fournisseurRepository.save(FournisseurDto.toEntity(fournisseurDto)));
	}

	@Override
	public FournisseurDto findById(Integer id) {
		if (id == null) {
			log.error("Fournisseur ID is null");
			return null;
		}
		return fournisseurRepository.findById(id).map(FournisseurDto::fromEntity).orElseThrow(
				() -> new EntityNotFoundException("le frounisseur avec ce id "+ id + "n'est pas touve dans la BDD", ErrorCodes.CATEGORY_NOT_FOUND));

	}

	@Override
	public List<FournisseurDto> findAll() {

		
		return fournisseurRepository.findAll().stream().map(FournisseurDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		
		if (id == null) {
			log.error("Fournisseur ID is null");
			return;
		}
		fournisseurRepository.deleteById(id);
	}

}
