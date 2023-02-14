package org.sid.contollers.api;

import io.swagger.annotations.Api;

import static org.sid.utils.Constants.UTILISATEUR_ENDPONT;

import java.util.List;

import org.sid.dto.UtlisateursDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api(UTILISATEUR_ENDPONT)
public interface UtlisateurApi {

	@PostMapping(value = UTILISATEUR_ENDPONT + "/create")
	UtlisateursDto save(@RequestBody UtlisateursDto utlisateurDto);

	@GetMapping(value = UTILISATEUR_ENDPONT + "/{idUtilisateur}")
	UtlisateursDto findById(@PathVariable("idUtilisateur") Integer id);

	@GetMapping(value = UTILISATEUR_ENDPONT + "/all")
	List<UtlisateursDto> findAll();

	@DeleteMapping(value = UTILISATEUR_ENDPONT + "/delete/{idUtilisateur}")
	void delete(@PathVariable("idUtilisateur") Integer id);

}
