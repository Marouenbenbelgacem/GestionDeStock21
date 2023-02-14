package org.sid.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.sid.dto.LigneVenteDto;
import org.sid.dto.VentesDto;
import org.sid.exception.ErrorCodes;
import org.sid.exception.InvalidEntityException;
import org.sid.exception.EntityNotFoundException;
import org.sid.model.Article;
import org.sid.model.LigneVente;
import org.sid.model.Ventes;
import org.sid.repository.ArticleRepository;
import org.sid.repository.LigneVentesRepository;
import org.sid.repository.VentesRepository;
import org.sid.services.VentesService;
import org.sid.validator.VentesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class VentesServiceImpl implements VentesService {

	private VentesRepository ventesRepository;
	private ArticleRepository articleRepository;
	private LigneVentesRepository ligneVentesRepository;

	@Autowired
	public VentesServiceImpl(VentesRepository ventesRepository, ArticleRepository articleRepository,
			LigneVentesRepository ligneVentesRepository) {
		this.articleRepository = articleRepository;
		this.ventesRepository = ventesRepository;
		this.ligneVentesRepository = ligneVentesRepository;
	}

	@Override
	public VentesDto save(VentesDto ventesDto) {
		List<String> errors = VentesValidator.validate(ventesDto);

		if (!errors.isEmpty()) {
			log.error("Vente n'est pas valide");
			throw new InvalidEntityException("l'objet vnte n'est pas valide", ErrorCodes.VENTES_NOT_VALID, errors);
		}

		List<String> articleErrors = new ArrayList<String>();

		ventesDto.getLigneVentes().forEach(ligVentes -> {
			Optional<Article> articleVentes = articleRepository.findById(ligVentes.getArticle().getId());
			if (articleVentes.isEmpty()) {
				articleErrors
						.add("Aucun article aved L'id" + ligVentes.getArticle().getId() + "n'a ete trouve dan lla BDD");
			}
		});
		if (!articleErrors.isEmpty()) {
			log.error("One or more articles are not valid", errors);
			throw new InvalidEntityException("Un ou plusieur article sont pas valid", ErrorCodes.VENTES_NOT_VALID,
					errors);

		}

		Ventes savedVente = ventesRepository.save(VentesDto.toEntity(ventesDto));

		ventesDto.getLigneVentes().forEach(ligVentes -> {
			LigneVente ligneVente = LigneVenteDto.toEntity(ligVentes);
			ligneVente.setVente(savedVente);
			ligneVentesRepository.save(ligneVente);
		});

		return VentesDto.fromEntity(savedVente);

	}

	@Override
	public VentesDto findById(Integer id) {

		if (id == null) {
			log.error("Vente ID is Null");
			return null;
		}
		return ventesRepository.findById(id).map(VentesDto::fromEntity).orElseThrow(
				() -> new EntityNotFoundException("Aucun vente n'a ete trouve", ErrorCodes.VENTES_NOT_FOUND));
	}

	@Override
	public VentesDto findByCode(String code) {
		if (!StringUtils.hasLength(code)) {
			log.error("Vente  code is Null");
			return null;
		}

		return ventesRepository.findVentesByCode(code).map(VentesDto::fromEntity).orElseThrow(
				() -> new EntityNotFoundException("Aucun vente n'a ete trouve", ErrorCodes.VENTES_NOT_VALID));
	}

	@Override
	public List<VentesDto> findAll() {

		return ventesRepository.findAll()
				.stream()
				.map(VentesDto::fromEntity)
				.collect(Collectors.toList());
		
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Ventes ID is Null");
		}
				ventesRepository.deleteById(id);
			}
	}


