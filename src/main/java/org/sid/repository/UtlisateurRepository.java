package org.sid.repository;

import java.util.Optional;

import org.sid.model.Utlisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UtlisateurRepository extends JpaRepository<Utlisateurs, Integer> {
	
	
	// JPQL query
	@Query(value = "select u from Utlisateurs u where u.email = :email")
	Optional<Utlisateurs> findUtlisateursByEmail (String email);

}
