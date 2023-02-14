package org.sid.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;

import org.sid.model.Adresses;
import org.sid.model.CommandeFournisseur;
import org.sid.model.Fournisseur;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class FournisseurDto {
	private Integer id;

	private String nom;

	private String preNom;
	
	private AdressesDto adresse;

	private String email;

	private String photo;

	private String numTel;
	@JsonIgnore
	private List<CommandeFournisseurDto> commandeFournisseurs;
	
	
	public static FournisseurDto fromEntity (Fournisseur fournisseur) {
		
		if (fournisseur == null) {
			return null;
		}
		return FournisseurDto.builder()
				.id(fournisseur.getId())
				.nom(fournisseur.getNom())
				.preNom(fournisseur.getPreNom())
				.adresse(AdressesDto.fromEntity(fournisseur.getAdresse()))
				.email(fournisseur.getEmail())
				.photo(fournisseur.getPhoto())
				.numTel(fournisseur.getNumTel())
			//	.commandeFournisseurs(CommandeFournisseurDto.fromEntity(fournisseur.getCommandeFournisseurs()))
				.build();
	}
	public static Fournisseur toEntity (FournisseurDto fournisseurDto) {
		if (fournisseurDto == null) {
			return null;
		}
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setId(fournisseurDto.getId());
		fournisseur.setNom(fournisseurDto.getNom());
		fournisseur.setPreNom(fournisseurDto.getPreNom());
		fournisseur.setAdresse(AdressesDto.toEntity(fournisseurDto.getAdresse()));
		fournisseur.setEmail(fournisseurDto.getEmail());
		fournisseur.setPhoto(fournisseurDto.getPhoto());
		fournisseur.setNumTel(fournisseurDto.getNumTel());
		//fournisseur.getCommandeFournisseurs(CommandeFournisseurDto.toEntity(fournisseurDto.getCommandeFournisseurs()));
		return fournisseur;
	}
}
