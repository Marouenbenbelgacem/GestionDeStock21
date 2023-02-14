package org.sid.contollers;

import java.util.List;

import org.sid.contollers.api.CategoryApi;
import org.sid.dto.CategoryDto;
import org.sid.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController implements CategoryApi {
	
	private CategoryService categoryService;
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public CategoryDto save(CategoryDto categoryDto) {
		return categoryService.save(categoryDto);
	}

	@Override
	public CategoryDto findById(Integer id) {
		return categoryService.findById(id);
	}

	@Override
	public CategoryDto findByCodeCategory(String codeCategory) {
		return categoryService.findByCodeCategory(codeCategory);
	}

	@Override
	public List<CategoryDto> findAll() {
		return categoryService.findAll();
	}

	@Override
	public void delete(Integer id) {
		categoryService.delete(id);

	}

}
