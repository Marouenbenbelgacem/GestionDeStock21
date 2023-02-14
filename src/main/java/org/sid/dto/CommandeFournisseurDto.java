package org.sid.dto;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.sid.model.CommandeClient;
import org.sid.model.CommandeFournisseur;
import org.sid.model.Fournisseur;
import org.sid.model.LigneCommandeFournisseur;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeFournisseurDto {
	private Integer id;

	private String code;

	private Instant dateCommande;

	private FournisseurDto fournisseur;
@JsonIgnore
	private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

	public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
		if (commandeFournisseur == null) {
			return null;
		}
		return CommandeFournisseurDto.builder().id(commandeFournisseur.getId()).code(commandeFournisseur.getCode())
				.dateCommande(commandeFournisseur.getDateCommande())
				.fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
				//.ligneCommandeFournisseurs(LigneCommandeFournisseurDto.fromEntity(commandeFournisseur.getLigneCommandeFournisseurs()))
				.build();
	}

	public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto) {
		if (commandeFournisseurDto == null) {
			return null;
		}
		CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
		commandeFournisseur.setId(commandeFournisseur.getId());
		commandeFournisseur.setCode(commandeFournisseur.getCode());
		commandeFournisseur.setDateCommande(commandeFournisseur.getDateCommande());
		commandeFournisseur.setFournisseur(commandeFournisseur.getFournisseur());
	//	commandeFournisseur.setLigneCommandeFournisseurs(LigneCommandeFournisseurDto.toEntity(commandeFournisseur.getLigneCommandeFournisseurs()));
		return commandeFournisseur;
	}

}
