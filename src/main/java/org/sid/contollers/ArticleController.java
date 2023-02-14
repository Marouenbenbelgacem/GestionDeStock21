package org.sid.contollers;

import java.util.List;

import org.sid.contollers.api.ArticleApi;
import org.sid.dto.ArticleDto;
import org.sid.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController implements ArticleApi {

	public ArticleService articleService;

	@Autowired
	ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Override
	public ArticleDto save(ArticleDto articledto) {
		return articleService.save(articledto);
	}

	@Override
	public ArticleDto findById(Integer id) {
		return articleService.findById(id);
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		return articleService.findByCodeArticle(codeArticle);
	}

	@Override
	public List<ArticleDto> findAll() {
		return articleService.findAll();
	}

	@Override
	public void delete(Integer id) {
		articleService.delete(id);
	}

}
