package org.sid.contollers;

import java.util.List;

import org.sid.contollers.api.UtlisateurApi;
import org.sid.dto.UtlisateursDto;
import org.sid.services.UtlisateurService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilisateurController implements UtlisateurApi {
	
	private UtlisateurService utilisateurService;
	
	public UtilisateurController (UtlisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@Override
	public UtlisateursDto save(UtlisateursDto utlisateurDto) {
		// TODO Auto-generated method stub
		return utilisateurService.save(utlisateurDto);
	}

	@Override
	public UtlisateursDto findById(Integer id) {
		// TODO Auto-generated method stub
		return utilisateurService.findById(id);
	}

	@Override
	public List<UtlisateursDto> findAll() {
		// TODO Auto-generated method stub
		return utilisateurService.findAll();
	}

	@Override
	public void delete(Integer id) {
		utilisateurService.delete(id);		
	}

}
