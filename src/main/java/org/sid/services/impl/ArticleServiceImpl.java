package org.sid.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.sid.exception.EntityNotFoundException;
import org.sid.dto.ArticleDto;
import org.sid.exception.ErrorCodes;
import org.sid.exception.InvalidEntityException;
import org.sid.model.Article;
import org.sid.repository.ArticleRepository;
import org.sid.services.ArticleService;
import org.sid.validator.ArticleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

	private ArticleRepository articleRepository;

	@Autowired
	public ArticleServiceImpl(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	public ArticleDto save(ArticleDto articledto) { // but: si l'article not valid on va logger l'error et throw an
													// exception avec le code 1000
		List<String> errors = ArticleValidator.validate(articledto);
		if (!errors.isEmpty()) {
			log.error("Article is not valid {}", articledto);
			throw new InvalidEntityException("l'article n'est valid", ErrorCodes.ARTICLE_NOT_VALID, errors);
		}
		return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(articledto)));
	}

	@Override
	public ArticleDto findById(Integer id) {
		if (id == null) {
			log.error("Articel Id is null");
			return null;
		}
		Optional<Article> article = articleRepository.findById(id);

		ArticleDto articleDto = ArticleDto.fromEntity(article.get());

		return Optional.of(articleDto).orElseThrow(() -> new EntityNotFoundException(
				"Aucun article avec l'ID" + id + "n'ete trouve dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		if (codeArticle == null) {
			log.error("Articel CODE is null");
			return null;
		}

		Optional<Article> article = articleRepository.findByCodeArticle(codeArticle);

		ArticleDto articleDto = ArticleDto.fromEntity(article.get());

		return Optional.of(articleDto)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun article avec le Code =" + codeArticle + "n'ete trouve dans la BDD",
						ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<ArticleDto> findAll() {
		return articleRepository.findAll()
				.stream()
				.map(ArticleDto::fromEntity)
				.collect(Collectors.toList()); //exposer a lexterieur seulement les articledto
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Articel Id is null");
			return;
		}
		articleRepository.deleteById(id);
	}
}
