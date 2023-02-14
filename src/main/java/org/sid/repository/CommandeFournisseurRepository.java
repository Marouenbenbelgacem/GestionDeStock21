package org.sid.repository;

import java.util.Optional;

import org.sid.model.CommandeClient;
import org.sid.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeFournisseurRepository extends  JpaRepository<CommandeFournisseur, Integer> {
	
	Optional <CommandeFournisseur> findCommandeFournisseurByCode (String code);


}
