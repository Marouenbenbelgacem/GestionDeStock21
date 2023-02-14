package org.sid.services.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.sid.dto.EntrepriseDto;
import org.sid.dto.RolesDto;
import org.sid.dto.UtlisateursDto;
import org.sid.exception.EntityNotFoundException;
import org.sid.exception.ErrorCodes;
import org.sid.exception.InvalidEntityException;
import org.sid.model.Entreprise;
import org.sid.repository.EntrepriseRepository;
import org.sid.repository.RolesRepository;
import org.sid.services.EntrepriseService;
import org.sid.services.UtlisateurService;
import org.sid.validator.EntrepriseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

	public EntrepriseRepository entrepriseRepository;
	  private UtlisateurService utilisateurService;
	  private RolesRepository rolesRepository;

	@Autowired
	public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
		this.entrepriseRepository = entrepriseRepository;
	}

	@Override
	public EntrepriseDto save(EntrepriseDto entrepriseDto) {

		List<String> errors = EntrepriseValidator.validate(entrepriseDto);
		if (!errors.isEmpty()) {
			log.error("Entrprise is not exist");
			throw new InvalidEntityException("Entreprise n'est pas trouve", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
		}
		
		
		 EntrepriseDto savedEntreprise = EntrepriseDto.fromEntity(
			        entrepriseRepository.save(EntrepriseDto.toEntity(entrepriseDto))
			    );
		 UtlisateursDto utilisateur = fromEntreprise(savedEntreprise);

		 UtlisateursDto savedUser = utilisateurService.save(utilisateur);

		    RolesDto rolesDto = RolesDto.builder()
		        .roleName("ADMIN")
		        .utlisateur(savedUser)
		        .build();
		    rolesRepository.save(RolesDto.toEntity(rolesDto));

		    return  savedEntreprise;
	}
	private UtlisateursDto fromEntreprise(EntrepriseDto entrepriseDto) {
	    return UtlisateursDto.builder()
	        .adresse(entrepriseDto.getAdresse())
	        .nom(entrepriseDto.getNom())
	        .preNom(entrepriseDto.getCodeFiscale())
	        .email(entrepriseDto.getEmail())
	        .motDePass(/*generateRandomPassword()*/ "skskLim@skaska")
	        .entreprise(entrepriseDto)
	        .dateDeNaissance(Instant.now())
	        .photo(entrepriseDto.getPhoto())
	        .build();
	 		    	    		
		//return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(entrepriseDto)));	

	}

	@Override
	public EntrepriseDto findById(Integer id) {
		if (id == null) {
			log.error("the Entreprise Id is null");
			return null;
		}
		Optional<Entreprise> entreprise = entrepriseRepository.findById(id);

		EntrepriseDto entrepriseDto = EntrepriseDto.fromEntity(entreprise.get());

		return Optional.of(entrepriseDto)
				.orElseThrow(() -> new EntityNotFoundException("Entreprise avec ce id" + id + "n'est pas trouve",
						ErrorCodes.ENTREPRISE_NOT_FOUND));
	}

	@Override
	public List<EntrepriseDto> findAll() {

		return entrepriseRepository.findAll().stream().map(EntrepriseDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id==null) {
			log.error("Client is null {}");
			return;
		}
		entrepriseRepository.deleteById(id);
	}

}
