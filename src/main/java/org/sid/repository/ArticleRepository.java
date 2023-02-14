package org.sid.repository;

import java.util.Optional;

import org.sid.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends  JpaRepository<Article, Integer> {

	Optional<Article> findByCodeArticle (String codeArticel);
	
}
