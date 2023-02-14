package org.sid.services;

import java.util.List;

import org.sid.dto.CategoryDto;

public interface CategoryService {

	CategoryDto save(CategoryDto categoryDto);

	CategoryDto findById(Integer id);

	CategoryDto findByCodeCategory(String codeCategory);

	List<CategoryDto> findAll();

	void delete(Integer id);

}
