package org.sid.services;

import static org.sid.utils.Constants.APP_ROOT;

import java.util.List;

import org.sid.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.annotations.Api;



public interface ClientService {
	
	ClientDto save(ClientDto clientDto);

	ClientDto findById(Integer id);

	List<ClientDto> findAll();

	void delete(Integer id);

}
