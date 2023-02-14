package org.sid.contollers;

import java.util.List;

import org.sid.contollers.api.CommandeClientApi;
import org.sid.dto.CommandeClientDto;
import org.sid.services.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandeClientController implements CommandeClientApi {

	private CommandeClientService commandeClientService;

	@Autowired
	CommandeClientController(CommandeClientService commandeClientService) {
		this.commandeClientService = commandeClientService;
	}

	@Override
	public ResponseEntity<CommandeClientDto> save(CommandeClientDto commandeClientDto) {
		return ResponseEntity.ok(commandeClientService.save(commandeClientDto));
		 
		//return ResponseEntity.status(HttpStatus.OK).body(commandeClientService.save(commandeClientDto)) // une autre fcon pour implementer la methode Save en utilisant le REsponse Entity
	}

	@Override
	public ResponseEntity<CommandeClientDto> findById(Integer id) {
		return ResponseEntity.ok(commandeClientService.findById(id));
		//return ResponseEntity.status(HttpStatus.OK).body(commandeClientService.findById(id));
	}

	@Override
	public ResponseEntity<CommandeClientDto> findByCode(String code) {
		// TODO Auto-generated method stub
	 		return ResponseEntity.ok(commandeClientService.findByCode(code));
	}

	@Override
	public ResponseEntity<List<CommandeClientDto>> findAll() {
		// TODO Auto-generated method stub
			return ResponseEntity.ok(commandeClientService.findAll());

	}

	@Override
	public ResponseEntity delete(Integer id) {
		commandeClientService.delete(id);
			return  ResponseEntity.ok().build(); // Response Entity ne foctionne pas avec les type void donc il faut ajouter build()

	}

}
