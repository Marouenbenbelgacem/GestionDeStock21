package org.sid.contollers.api;

import static org.sid.utils.Constants.APP_ROOT;

import java.util.List;

import org.sid.dto.ArticleDto;
import org.sid.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(APP_ROOT + "/categories")

public interface CategoryApi {

	@PostMapping(value = APP_ROOT
			+ "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Ajouter une Categorie", notes = "cette methode permet d'enregidtrer ou modifer une Categorie", response = CategoryDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lobjet Categorie cree / modifier"),
			@ApiResponse(code = 400, message = "Lobjet Categorie n'est pas valid") })
	CategoryDto save(@RequestBody CategoryDto categoryDto);
	
	@GetMapping(value = APP_ROOT + "/categories/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Recherche une Categorie par ID", notes = "cette methode permet de trouver une Categorie par son ID", response = CategoryDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lobjet Categorie trouve dans la BDD"),
			@ApiResponse(code = 200, message = "Lobjet Categorie n'est pas trouve dans la BDD") })

	CategoryDto findById(@PathVariable ("idCategory") Integer id);

	@GetMapping(value = APP_ROOT + "/categories/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Recherche un Categorie par code", notes = "cette methode permet de trouver une Categorie par son code", response = CategoryDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lobjet Categorie trouve dans la BDD"),
			@ApiResponse(code = 404, message = "Lobjet Categorie n'est pas trouve dans la BDD") })
	CategoryDto findByCodeCategory(@PathVariable("codeCategory")String codeCategory);

	@GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Recherche tous les Catgories", notes = "cette methode permet de trouver tous les categories", responseContainer = "List<CategoryDto>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "La List des Categories / List Vide") })
	List<CategoryDto> findAll();

	@DeleteMapping(value = APP_ROOT + "/catgories/delete/{idCategory}")
	@ApiOperation(value = "Supprimer une Categorie", notes = "cette methode permet de supprimer une Categorie", response = ArticleDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "La categorie a ete supprime") })
	void delete(@PathVariable("idCategory")Integer id);	
	
}
