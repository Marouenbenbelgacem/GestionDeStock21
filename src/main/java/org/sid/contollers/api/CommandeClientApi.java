package org.sid.contollers.api;

import static org.sid.utils.Constants.APP_ROOT;

import java.util.List;

import org.sid.dto.CommandeClientDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;

@Api(APP_ROOT + "/commandesClients")

public interface CommandeClientApi {

	@PostMapping(value = APP_ROOT+ "/commandesClients/create")
	ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto commandeClientDto);
	
	@GetMapping(value = APP_ROOT + "/commandesClients/{idCommandeClient}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<CommandeClientDto> findById(@PathVariable Integer idCommandeClient);
	
	@GetMapping(value = APP_ROOT + "/commandesClients/{codeCommandeClient}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codeCommandeClient") String code);

	@GetMapping(value = APP_ROOT + "/commandesClients/all", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<CommandeClientDto>> findAll();
	
	@DeleteMapping(value = APP_ROOT + "/commandesClients/delete/{idCommandeClient}")
	ResponseEntity delete(@PathVariable Integer idCommandeClient);
}
