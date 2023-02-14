package org.sid.contollers;

import java.util.List;

import org.sid.contollers.api.FournisseurApi;
import org.sid.dto.FournisseurDto;
import org.sid.services.FournisseurService;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FournisseurController implements FournisseurApi{
	
	private FournisseurService fournisseurService;
	
	FournisseurController(FournisseurService fournisseurService){
		this.fournisseurService = fournisseurService;
	}

	@Override
	public FournisseurDto save(FournisseurDto fournisseurDto) {
		return fournisseurService.save(fournisseurDto);
	}

	@Override
	public FournisseurDto findById(Integer id) {
		// TODO Auto-generated method stub
		return fournisseurService.findById(id);
	}

	@Override
	public List<FournisseurDto> findAll() {
		// TODO Auto-generated method stub
		return fournisseurService.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		fournisseurService.delete(id);
	}

}
