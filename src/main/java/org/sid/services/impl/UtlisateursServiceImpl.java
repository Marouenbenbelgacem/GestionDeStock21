package org.sid.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.sid.dto.UtlisateursDto;
import org.sid.exception.EntityNotFoundException;
import org.sid.exception.ErrorCodes;
import org.sid.exception.InvalidEntityException;
import org.sid.repository.UtlisateurRepository;
import org.sid.services.UtlisateurService;
import org.sid.validator.UtlisateursValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtlisateursServiceImpl implements UtlisateurService {

	public UtlisateurRepository utlisteurRepository;

	@Autowired
	public UtlisateursServiceImpl(UtlisateurRepository utlisteurRepository) {
		this.utlisteurRepository = utlisteurRepository;
	}

	public UtlisateursServiceImpl() {
	}
	@Override
	public UtlisateursDto save(UtlisateursDto utlisateursDto) {

		List<String> errors = UtlisateursValidator.validate(utlisateursDto);
		if (!errors.isEmpty()) {
			log.error("Utlisateur is not valid {}");
			throw new InvalidEntityException("utlisateur n'est pas valid", ErrorCodes.UTLISATEUR_NOT_VALID, errors);
		}

		return UtlisateursDto.fromEntity(utlisteurRepository.save(UtlisateursDto.toEntity(utlisateursDto)));
	}

	@Override
	public UtlisateursDto findById(Integer id) {

		if (id== null) {
			log.error("Utlisateur id is not valid");
			return null;
		}
		
		return utlisteurRepository.findById(id)
				.map(UtlisateursDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("utlistaur avec ce ID " + id + "ne trouve pas dans la BDD" , ErrorCodes.UTLISATEUR_NOT_FOUND));
	}

	@Override
	public List<UtlisateursDto> findAll() {


		return utlisteurRepository.findAll().stream().map(UtlisateursDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id== null) {
			log.error("Utlisateur id is not valid");
			return;}
		utlisteurRepository.deleteById(id);
	}

	@Override
	public UtlisateursDto findByEmail(String email) {
		
		return utlisteurRepository.findUtlisateursByEmail(email)
				.map(UtlisateursDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException(
						"Aucun Utlisateur avec l'email = " + email + ErrorCodes.UTLISATEUR_NOT_FOUND));
		
	}
	
	

}
