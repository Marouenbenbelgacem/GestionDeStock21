package org.sid.dto;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;

import org.sid.model.Adresses;
import org.sid.model.Entreprise;
import org.sid.model.Utlisateurs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {
	private Integer id;
	private String nom;
	private String description;
	private AdressesDto adresse;
	private String codeFiscale;
	private String photo;
	private String email;
	private String numTel;
	private String siteWeb;
	@JsonIgnore
	private List<UtlisateursDto> utilisateurs;
	
	
	public static EntrepriseDto fromEntity (Entreprise entreprise) {
		if (entreprise== null) {
			return null;
		}
		
		return EntrepriseDto.builder()
				.id(entreprise.getId())
				.nom(entreprise.getNom())
				.description(entreprise.getDescription())
				.adresse(AdressesDto.fromEntity(entreprise.getAdresse()))
				.codeFiscale(entreprise.getCodeFiscale())
				.photo(entreprise.getPhoto())
				.email(entreprise.getEmail())
				.numTel(entreprise.getNumTel())
				.siteWeb(entreprise.getSiteWeb())
			//	.utilisateurs(UtlisateursDto.fromEntity(entreprise.getUtlisateurs().stream().map()))
				.build();
				
	}
	
	public static Entreprise toEntity (EntrepriseDto entrepriseDto) {
		if (entrepriseDto == null) {
			return null;
		}
		 Entreprise entreprise = new Entreprise();
		 entreprise.setId(entrepriseDto.getId());
		 entreprise.setNom(entrepriseDto.getNom());
		 entreprise.setDescription(entrepriseDto.getDescription());
		 entreprise.setAdresse(AdressesDto.toEntity(entrepriseDto.getAdresse()));
		 entreprise.setCodeFiscale(entrepriseDto.getCodeFiscale());
		 entreprise.setPhoto(entrepriseDto.getPhoto());
		 entreprise.setEmail(entrepriseDto.getEmail());
		 entreprise.setNumTel(entrepriseDto.getNumTel());
		 entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
		// entreprise.setUtlisateurs(UtlisateursDto.toEntity(entrepriseDto.getUtlisateurs()));
	
		 return entreprise;
		
	}
	
	
}
