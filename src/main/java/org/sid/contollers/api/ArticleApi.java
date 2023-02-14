package org.sid.contollers.api;

import java.util.List;

import org.sid.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import static org.sid.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/articles")
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")


public interface ArticleApi {

    @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ajouter et modifer un Article", notes = "cette methode permet d'enregistrer ou modifer un article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lobjet Article créer / modifier"),
            @ApiResponse(code = 400, message = "Lobjet Article n'est pas valide")})
    ArticleDto save(@RequestBody ArticleDto articledto);


    @GetMapping(value = APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un Article par ID", notes = "cette methode permet de trouver un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Lobjet Article trouve dans la BDD"),
            @ApiResponse(code = 200, message = "Lobjet Article n'est pas trouve dans la BDD")})
    ArticleDto findById(@PathVariable("idArticle") Integer id);


    @GetMapping(value = APP_ROOT + "/articles/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un Article par code", notes = "cette methode permet de trouver un article par son code", response = ArticleDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Lobjet Article trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Lobjet Article n'est pas trouve dans la BDD")})
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);


    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche tous les Articles", notes = "cette methode permet de trouver tous les Articles", responseContainer = "List<ArticleDto >")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La List des Articles / List Vide")})
    List<ArticleDto> findAll();


    @DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}")
    @ApiOperation(value = "Supprimer un Article", notes = "cette methode permet de supprimer un Article", response = ArticleDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "L'article a ete supprime")})
    void delete(@PathVariable("idArticle") Integer id);
}

//public class SingletonClasse {
//	
//	private static singletonClasse instance;
//	private SingletonClasse () {}
//	public static SingletinClasse getInstance {
//		if (instace == null) {
//			instance = new SingletonClasse;			
//		}
//		return instance
//	}
//	
//	
//}
