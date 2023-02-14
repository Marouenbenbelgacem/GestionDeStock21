package org.sid.contollers;

import java.util.List;

import org.sid.contollers.api.VentesApi;
import org.sid.dto.VentesDto;
import org.sid.services.VentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VenteController implements VentesApi {
	
	private VentesService ventesSerice;
	@Autowired
	public VenteController (VentesService ventesSeri) {
		this.ventesSerice = ventesSerice;
	}

	@Override
	public VentesDto save(VentesDto ventesDto) {
		// TODO Auto-generated method stub
		return ventesSerice.save(ventesDto);
	}

	@Override
	public VentesDto findById(Integer id) {
		// TODO Auto-generated method stub
		return ventesSerice.findById(id);
	}

	@Override
	public VentesDto findByCode(String code) {
		// TODO Auto-generated method stub
		return ventesSerice.findByCode(code);
	}

	@Override
	public List<VentesDto> findAll() {
		// TODO Auto-generated method stub
		return ventesSerice.findAll();
	}

	@Override
	public void delete(Integer id) {
		ventesSerice.delete(id);		
	}

}
