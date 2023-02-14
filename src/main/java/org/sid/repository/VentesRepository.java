package org.sid.repository;

import java.util.Optional;

import org.sid.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentesRepository extends JpaRepository<Ventes, Integer> {

	
	Optional<Ventes> findVentesByCode (String code);
}
