package org.sid.repository;

import java.util.Optional;

import org.sid.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

	Optional <Category> findByCodeCategory (String codeCategory);
	
	
}
