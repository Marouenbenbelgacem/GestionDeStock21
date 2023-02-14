package org.sid.contollers;

import java.util.List;

import org.sid.contollers.api.ClientApi;
import org.sid.dto.ClientDto;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ClientController implements ClientApi {

	@Override
	public ClientDto save(ClientDto clientDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientDto findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
