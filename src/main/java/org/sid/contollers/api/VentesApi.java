package org.sid.contollers.api;

import io.swagger.annotations.Api;

import static org.sid.utils.Constants.FOURNISSEUR_ENDPOINT;
import static org.sid.utils.Constants.VENTE_ENDPONT;
import java.util.List;
import org.sid.dto.VentesDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Api (VENTE_ENDPONT)
public interface VentesApi {
	
	@PostMapping(value = VENTE_ENDPONT + "/create")
	VentesDto save(VentesDto ventesDto);
	
	@GetMapping(value = VENTE_ENDPONT+ "/{idVente}")
	VentesDto findById(@PathVariable ("idVente") Integer id);
	
	@GetMapping(value = VENTE_ENDPONT + "/{codeVente}")
	VentesDto findByCode (@PathVariable ("codeVente") String code);
	
	@GetMapping(value = VENTE_ENDPONT + "/all")
	List<VentesDto> findAll();
	
	@DeleteMapping(value = VENTE_ENDPONT + "/delete/{idVente}")
	void delete(@PathVariable ("idVente") Integer id);

}
