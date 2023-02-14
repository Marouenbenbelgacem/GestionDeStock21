package org.sid.contollers.api;

import static org.sid.utils.Constants.APP_ROOT;

import java.util.List;

import org.sid.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.annotations.Api;

@Api(APP_ROOT + "/clients")

public interface ClientApi {

	@PostMapping(value = APP_ROOT+ "/clients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ClientDto save(ClientDto clientDto);

	@GetMapping(value = APP_ROOT + "/clients/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
	ClientDto findById(@PathVariable("idClient") Integer id);

	@GetMapping(value = APP_ROOT + "/clients/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<ClientDto> findAll();

	@DeleteMapping(value = APP_ROOT + "/clients/delete/{idClient}")
	void delete(Integer id);

}
