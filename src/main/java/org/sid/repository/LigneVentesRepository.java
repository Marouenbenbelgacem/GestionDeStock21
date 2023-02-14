package org.sid.repository;

import org.sid.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneVentesRepository extends JpaRepository <LigneVente, Integer> {

}
