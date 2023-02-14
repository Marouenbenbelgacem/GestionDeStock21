package org.sid.contollers.api;

import static org.sid.utils.Constants.APP_ROOT;

import java.util.List;

import org.sid.dto.CommandeFournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;

@Api(APP_ROOT + "/commandesFournisseurs")

public interface CommandeFournissuerApi {

	@PostMapping(value = APP_ROOT + "/commandesFournisseurs/create")
	CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto commandeFournisseurDto);

	@GetMapping(value = APP_ROOT
			+ "/commandesFournisseurs/{idCommandeFournisseurs}", produces = MediaType.APPLICATION_JSON_VALUE)
	CommandeFournisseurDto findById(@PathVariable("idCommandeFournisseurs") Integer id);

	@GetMapping(value = APP_ROOT
			+ "/commandesFournisseurs/{codeCommandeFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
	CommandeFournisseurDto findByCode(@PathVariable String codeCommandeFournisseur);

	@GetMapping(value = APP_ROOT + "/commandesFournisseurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<CommandeFournisseurDto> findAll();

	@DeleteMapping(value = APP_ROOT + "/commandesFournisseurs/delete/{idCommandeFournisseurs}")
	void delete(@PathVariable("idCommandeFournisseurs") Integer id);

}
