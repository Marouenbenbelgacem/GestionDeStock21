package org.sid.contollers.api;

import io.swagger.annotations.Api;

import static org.sid.utils.Constants.APP_ROOT;
import static org.sid.utils.Constants.FOURNISSEUR_ENDPOINT;

import java.util.List;

import org.sid.dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Api(FOURNISSEUR_ENDPOINT)
public interface FournisseurApi {

	@PostMapping(value = FOURNISSEUR_ENDPOINT + "/create")
	FournisseurDto save(FournisseurDto fournisseurDto);
	
	@GetMapping(value = FOURNISSEUR_ENDPOINT+ "/{idFournisseur}")
	FournisseurDto findById(@PathVariable ("idFournisseur") Integer id);
	
	@GetMapping(value = FOURNISSEUR_ENDPOINT + "/all")
	List<FournisseurDto> findAll();

	@DeleteMapping(value = FOURNISSEUR_ENDPOINT + "/delete/{idFournisseur}")
	void delete(Integer id);
	
}
