package org.sid.contollers;

import java.util.List;

import org.sid.contollers.api.CommandeFournissuerApi;
import org.sid.dto.CommandeFournisseurDto;
import org.sid.services.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CommandeFournisseurController implements CommandeFournissuerApi{

	private CommandeFournisseurService commandeFournisseurService;
	@Autowired
	public CommandeFournisseurController(CommandeFournisseurService commandeFournisseurService){
		this.commandeFournisseurService = commandeFournisseurService;
		
	}
	@Override
	public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
		return commandeFournisseurService.save(commandeFournisseurDto);
	}

	@Override
	public CommandeFournisseurDto findById(Integer id) {
		return commandeFournisseurService.findById(id);
	}

	@Override
	public CommandeFournisseurDto findByCode(String codeCommandeFournisseur) {
		return commandeFournisseurService.findByCode(codeCommandeFournisseur);
	}

	@Override
	public List<CommandeFournisseurDto> findAll() {
		return commandeFournisseurService.findAll();
	}

	@Override
	public void delete(Integer id) {
		commandeFournisseurService.delete(id);
	}

}
