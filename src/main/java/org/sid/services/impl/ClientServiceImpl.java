package org.sid.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.sid.dto.ClientDto;
import org.sid.exception.EntityNotFoundException;
import org.sid.exception.ErrorCodes;
import org.sid.exception.InvalidEntityException;
import org.sid.model.Client;
import org.sid.repository.ClientRepository;
import org.sid.services.ClientService;
import org.sid.validator.ClientValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ClientServiceImpl implements ClientService{
	
	public ClientRepository clientRepository;

	@Autowired
	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public ClientDto save(ClientDto clientDto) {
		
		List<String> errors = ClientValidators.validate(clientDto);
		
		if (!errors.isEmpty()) {
		log.error("Client is not Valid {}");
			throw new InvalidEntityException("Client n'est pas valide",ErrorCodes.CLIENT_NOT_FOUND,errors); 
		}
		return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(clientDto)));
	}

	@Override
	public ClientDto findById(Integer id) {
		if (id==null) {
			log.error("Client is null {}");
			return null;
		}
		
		Optional<Client> client = clientRepository.findById(id);
		ClientDto clientDto = ClientDto.fromEntity(client.get());
		
		return Optional.of(clientDto).orElseThrow(() -> new EntityNotFoundException(
				"Client avec cette" + id + "ne trouve pas dans la BDD", ErrorCodes.CLIENT_NOT_FOUND));
	}

	@Override
	public List<ClientDto> findAll() {

		return clientRepository.findAll()
				.stream()
				.map(ClientDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id==null) {
			log.error("Client is null {}");
			return;
		}
		clientRepository.deleteById(id);
		
	}

	
	
	
	
}
