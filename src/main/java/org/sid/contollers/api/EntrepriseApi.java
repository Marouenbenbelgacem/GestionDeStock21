package org.sid.contollers.api;

import static org.sid.utils.Constants.APP_ROOT;

import java.util.List;

import org.sid.dto.EntrepriseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.annotations.Api;

@Api(APP_ROOT + "/entreprises")

public interface EntrepriseApi {

	@PostMapping(value = APP_ROOT + "/entreprises/create")
	EntrepriseDto save(EntrepriseDto entrepriseDto);
	
	@GetMapping(value = APP_ROOT
			+ "/entreprises/{idEntreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
	EntrepriseDto findById(@PathVariable("idEntrprise")Integer id);
	
	@GetMapping(value = APP_ROOT + "/entreprises/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<EntrepriseDto> findAll();
	
	@DeleteMapping(value = APP_ROOT + "/entreprises/delete/{idEntreprise}")

	void delete(Integer id);

}
