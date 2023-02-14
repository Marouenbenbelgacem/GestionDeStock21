package org.sid.services;

import java.util.List;

import org.sid.dto.ArticleDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")

public interface ArticleService {
	

	ArticleDto save(ArticleDto articledto);
	
	ArticleDto findById (Integer id);
	
	ArticleDto findByCodeArticle (String codeArticle);
	
	List<ArticleDto> findAll ();
	
	void delete (Integer id);
	
}
