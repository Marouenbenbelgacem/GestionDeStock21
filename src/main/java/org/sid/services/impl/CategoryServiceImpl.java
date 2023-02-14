package org.sid.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.sid.dto.ArticleDto;
import org.sid.dto.CategoryDto;
import org.sid.exception.EntityNotFoundException;
import org.sid.exception.ErrorCodes;
import org.sid.exception.InvalidEntityException;
import org.sid.model.Article;
import org.sid.model.Category;
import org.sid.repository.CategoryRepository;
import org.sid.services.CategoryService;
import org.sid.validator.CategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	public CategoryRepository categoryRepository;
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public CategoryDto save(CategoryDto categoryDto) {

		List<String> errors = CategoryValidator.validate(categoryDto);

		if (!errors.isEmpty()) {
			log.error("Category is not Valid {}");
			throw new InvalidEntityException("Category n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
		}

		return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(categoryDto)));
	}

	@Override
	public CategoryDto findById(Integer id) {

		/*
		 * -------------- une mannier pour impletmenter la methode save
		 * 
		 * if (id == null) { log.error("Articel Id is null"); return null; }
		 * Optional<Category> cat = categoryRepository.findById(id);
		 * 
		 * CategoryDto catDto = CategoryDto.fromEntity(cat.get());
		 * 
		 * return Optional.of(catDto).orElseThrow(() -> new EntityNotFoundException(
		 * "Aucun article avec l'ID" + id + "n'ete trouve dans la BDD",
		 * ErrorCodes.ARTICLE_NOT_FOUND));
		 */

		if (id == null) {
			log.error("category Id is null");
			return null;
		}

		return categoryRepository.findById(id).map(CategoryDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("Category n'est pas trouvé avec ce ID = " + id + " dans la BDD",
						ErrorCodes.CATEGORY_NOT_FOUND));

	}

	@Override
	public CategoryDto findByCodeCategory(String code) {

		if (!StringUtils.hasLength(code)) {
			log.error("The category code is null");
			return null;
		}
		return categoryRepository.findByCodeCategory(code).map(CategoryDto::fromEntity).orElseThrow(
				() -> new EntityNotFoundException("Category n'est trouve avec ce code" + code + "dans la BDD",
						ErrorCodes.CATEGORY_NOT_FOUND));

	}

	@Override
	public List<CategoryDto> findAll() {

		return categoryRepository.findAll().stream().map(CategoryDto::fromEntity).collect(Collectors.toList());

	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Catwgory Id is null");

		}
		categoryRepository.deleteById(id);
	}
}