package org.sid.repository;

import java.util.Optional;

import org.sid.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeClientRepository extends  JpaRepository <CommandeClient,Integer>{

	Optional <CommandeClient> findCommandeClientByCode (String code);
}
