package org.sid.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.sid.dto.CommandeClientDto;
import org.sid.dto.CommandeFournisseurDto;
import org.sid.dto.LigneCommandeClientDto;
import org.sid.exception.EntityNotFoundException;
import org.sid.exception.ErrorCodes;
import org.sid.exception.InvalidEntityException;
import org.sid.model.Article;
import org.sid.model.Client;
import org.sid.model.CommandeClient;
import org.sid.model.LigneCommandeClient;
import org.sid.repository.ArticleRepository;
import org.sid.repository.ClientRepository;
import org.sid.repository.CommandeClientRepository;
import org.sid.repository.LigneCommandeClientRepository;
import org.sid.services.CommandeClientService;
import org.sid.validator.CommandeClientValidator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {

	private CommandeClientRepository commandeClientRepository;
	private LigneCommandeClientRepository ligneCommandeClientRepository;
	private ClientRepository clientRepository;
	private ArticleRepository articleRepository;

	public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository,LigneCommandeClientRepository ligneCommandeClientRepository, ClientRepository clientRepository,ArticleRepository articleRepository ) {
		this.commandeClientRepository = commandeClientRepository;
		this.ligneCommandeClientRepository = ligneCommandeClientRepository;
		this.clientRepository = clientRepository;
		this.articleRepository = articleRepository;
	}

	@Override
	public CommandeClientDto save(CommandeClientDto commandeClientDto) {
		
		List<String> errors = CommandeClientValidator.validate(commandeClientDto);
		if (!errors.isEmpty()) {
			log.error("CommandeClient is not valid {}");
			throw new InvalidEntityException("CommandeClient n'est pas valid", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, errors);
		}
		
		Optional<Client> client = clientRepository.findById(commandeClientDto.getClient().getId());
		if (client.isEmpty()) {
			log.warn("Client with ID {} is not found in the DB",commandeClientDto.getClient().getId());
			throw new EntityNotFoundException("Aucun clinet aved l'id"+ commandeClientDto.getClient().getId() + "touve dans la BDD", ErrorCodes.CLIENT_NOT_FOUND);  
		}
		
		List<String> articleErrors = new ArrayList<String>();
		if (commandeClientDto.getLigneCommandeClients() !=null) {
			
			commandeClientDto.getLigneCommandeClients().forEach(ligCmdClt -> {
				if(ligCmdClt.getArticle()!= null) {
					Optional<Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());
					if (article.isEmpty()) {
						articleErrors.add("l'article avec l'ID" + ligCmdClt.getArticle().getId() + "ne trouve pas" );
						
					}
				}else {
					articleErrors.add("Impossible d'enregisterer une commande avec un article Null" );

				}
				
			});
		}
		if (!articleErrors.isEmpty()) {
			log.warn("Article is not found {}");
			throw new InvalidEntityException("Article n'exsite pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
		}
		
		//on a fait ca par ce que on peut pas energster une ligne de commandeclient qui est deja liee a une commande client on peut pas l'energister sans preciser une commandeClient
		CommandeClient savedCmdClt = commandeClientRepository.save(CommandeClientDto.toEntity(commandeClientDto));
		if (commandeClientDto.getLigneCommandeClients() !=null) {
			commandeClientDto.getLigneCommandeClients().forEach(ligCmdClt -> {
				LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
				ligneCommandeClient.setCommandeClient(savedCmdClt);
				ligneCommandeClientRepository.save(ligneCommandeClient);
			});
			
		}
		
		return CommandeClientDto.fromEntity(savedCmdClt) ;
	}

	@Override
	public CommandeClientDto findById(Integer id) {
		if (id == null) {
			log.error("Commande Client ID is Null");
			return null;
		}
		return commandeClientRepository.findById(id).map(CommandeClientDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("Aucun commande Client a ete trouver sous l'ID" + id,
						ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
	}

	@Override
	public CommandeClientDto findByCode(String code) {
		if (!StringUtils.hasLength(code)) {
			log.error("Commande Client code is Null");
			return null;
		}
		return commandeClientRepository.findCommandeClientByCode(code).map(CommandeClientDto::fromEntity)
				.orElseThrow(
						() -> new EntityNotFoundException("Aucun commande Client a ete trouver sous le code" + code,
								ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));

	}

	@Override
	public List<CommandeClientDto> findAll() {
		return commandeClientRepository.findAll()
				.stream()
				.map(CommandeClientDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
if (id == null) {
	log.error("Commande Client ID is Null");
}
		commandeClientRepository.deleteById(id);
	}

}
