package org.sid.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.sid.dto.CommandeFournisseurDto;
import org.sid.dto.LigneCommandeFournisseurDto;
import org.sid.exception.EntityNotFoundException;
import org.sid.exception.ErrorCodes;
import org.sid.exception.InvalidEntityException;
import org.sid.model.Article;
import org.sid.model.CommandeFournisseur;
import org.sid.model.Fournisseur;
import org.sid.model.LigneCommandeFournisseur;
import org.sid.repository.ArticleRepository;
import org.sid.repository.CommandeFournisseurRepository;
import org.sid.repository.FournisseurRepository;
import org.sid.repository.LigneCommandeFournisseurRepository;
import org.sid.services.CommandeFournisseurService;
import org.sid.validator.CommandeFournisseurValidator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

	private CommandeFournisseurRepository commandeFournisseurRepository;
	private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
	private FournisseurRepository fournisseurRepository;
	private ArticleRepository articleRepository;

	public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository,
			LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository,
			FournisseurRepository fournisseurRepository, ArticleRepository articleRepository) {
		this.commandeFournisseurRepository = commandeFournisseurRepository;
		this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
		this.fournisseurRepository = fournisseurRepository;
		this.articleRepository = articleRepository;
	}

	@Override
	public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {

		List<String> errors = CommandeFournisseurValidator.validate(commandeFournisseurDto);
		if (!errors.isEmpty()) {
			log.error("CommandeClient is not valid {}");
			throw new InvalidEntityException("CommandeClient n'est pas valid",
					ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID, errors);
		}

		Optional<Fournisseur> fournisseur = fournisseurRepository.findById(commandeFournisseurDto.getFournisseur().getId());
		if (fournisseur.isEmpty()) {
			log.warn("Fournisseur with ID {} is not found in the DB", commandeFournisseurDto.getFournisseur().getId());
			throw new EntityNotFoundException(
					"Aucun Fournisseur aved l'id" + commandeFournisseurDto.getFournisseur().getId() + "touve dans la BDD",
					ErrorCodes.FOURNISSEUR_NOT_FOUND);
		}

		List<String> articleErrors = new ArrayList<String>();
		if (commandeFournisseurDto.getLigneCommandeFournisseurs() != null) {

			commandeFournisseurDto.getLigneCommandeFournisseurs().forEach(ligCmdFournisseur -> {
				if (ligCmdFournisseur.getArticle() != null) {
					Optional<Article> article = articleRepository.findById(ligCmdFournisseur.getArticle().getId());
					if (article.isEmpty()) {
						articleErrors
								.add("l'article avec l'ID" + ligCmdFournisseur.getArticle().getId() + "ne trouve pas");

					}
				} else {
					articleErrors.add("Impossible d'enregisterer une commande avec un article Null");

				}

			});
		}
		if (!articleErrors.isEmpty()) {
			log.warn("Article is not found {}");
			throw new InvalidEntityException("Article n'exsite pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND,
					articleErrors);
		}

		// on a fait ca par ce que on peut pas energster une ligne de commandeclient qui
		// est deja liee a une commande client on peut pas l'energister sans preciser
		// une commandeClient
		CommandeFournisseur savedCmdFournisseur = commandeFournisseurRepository
				.save(CommandeFournisseurDto.toEntity(commandeFournisseurDto));
		if (commandeFournisseurDto.getLigneCommandeFournisseurs() != null) {
			commandeFournisseurDto.getLigneCommandeFournisseurs().forEach(ligCmdFournisseur -> {
				LigneCommandeFournisseur ligneCommandefournisseur = LigneCommandeFournisseurDto
						.toEntity(ligCmdFournisseur);
				ligneCommandefournisseur.setCommandeFournisseur(savedCmdFournisseur);
				ligneCommandeFournisseurRepository.save(ligneCommandefournisseur);
			});

		}

		return commandeFournisseurDto.fromEntity(savedCmdFournisseur);
	}

	@Override
	public CommandeFournisseurDto findById(Integer id) {

		if (id == null) {
			log.error("CommandeFournisseur ID is Null");
			return null;
		}
		return commandeFournisseurRepository.findById(id).map(CommandeFournisseurDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("Aucun commande fourniseur a ete trouver sous l'ID" + id,
						ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));

	}

	@Override
	public CommandeFournisseurDto findByCode(String code) {

		if (!StringUtils.hasLength(code)) {
			log.error("Commande Fournisseur code is Null");
			return null;
		}
		return commandeFournisseurRepository.findCommandeFournisseurByCode(code).map(CommandeFournisseurDto::fromEntity)
				.orElseThrow(
						() -> new EntityNotFoundException("Aucun commande fourniseur a ete trouver sous le code" + code,
								ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));

	}

	@Override
	public List<CommandeFournisseurDto> findAll() {
		return commandeFournisseurRepository.findAll().stream().map(CommandeFournisseurDto::fromEntity)
				.collect(Collectors.toList());

	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Commande Fourisseur ID is Null");
		}
		commandeFournisseurRepository.deleteById(id);
	}
}
