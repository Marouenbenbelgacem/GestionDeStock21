package org.sid.contollers;

import java.util.List;

import org.sid.contollers.api.EntrepriseApi;
import org.sid.dto.EntrepriseDto;
import org.sid.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EntrepriseController implements EntrepriseApi{
	
	@Autowired
	private EntrepriseService entrepriseService;

	
	@Override
	public EntrepriseDto save(EntrepriseDto entrepriseDto) {
		// TODO Auto-generated method stub
		return entrepriseService.save(entrepriseDto);
	}

	@Override
	public EntrepriseDto findById(Integer id) {
		// TODO Auto-generated method stub
		return entrepriseService.findById(id);
	}

	@Override
	public List<EntrepriseDto> findAll() {
		// TODO Auto-generated method stub
		return entrepriseService.findAll();
	}

	@Override
	public void delete(Integer id) {
		entrepriseService.delete(id);		
	}

}
