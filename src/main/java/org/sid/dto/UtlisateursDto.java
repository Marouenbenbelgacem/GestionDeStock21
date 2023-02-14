package org.sid.dto;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.sid.model.Adresses;
import org.sid.model.Entreprise;
import org.sid.model.Roles;
import org.sid.model.Utlisateurs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtlisateursDto {
	private Integer id;
	private String nom;
	private String preNom;
	private String email;
	private Instant dateDeNaissance;
	private String motDePass;
	private AdressesDto adresse;

	private String photo;

	private EntrepriseDto entreprise;
	@JsonIgnore
	private List<RolesDto> roles;

	public static UtlisateursDto fromEntity(Utlisateurs utlisateurs) {
		if (utlisateurs == null) {
			return null;
		}

		return UtlisateursDto.builder().id(utlisateurs.getId()).nom(utlisateurs.getNom())
				.preNom(utlisateurs.getPreNom()).email(utlisateurs.getEmail())
				.dateDeNaissance(utlisateurs.getDateDeNaissance()).motDePass(utlisateurs.getMotDePass())
				.entreprise(EntrepriseDto.fromEntity(utlisateurs.getEntreprise()))
				// .roles(RolesDto.fromEntity(utlisateurs.getRoles()))
				.build();
	}

	public static Utlisateurs toEntity(UtlisateursDto utlisateursDto) {
		if (utlisateursDto == null) {
			return null;
		}
		Utlisateurs utlisateur = new Utlisateurs();
		utlisateur.setId(utlisateursDto.getId());
		utlisateur.setNom(utlisateursDto.getNom());
		utlisateur.setPreNom(utlisateursDto.getPreNom());
		utlisateur.setEmail(utlisateursDto.getEmail());
		utlisateur.setDateDeNaissance(utlisateursDto.getDateDeNaissance());
		utlisateur.setMotDePass(utlisateursDto.getMotDePass());
		utlisateur.setEntreprise(EntrepriseDto.toEntity(utlisateursDto.getEntreprise()));
		// utlisateur.setRoles(RolesDto.toEntity(utlisateursDto.getRoles()));
		return utlisateur;
	}
}
