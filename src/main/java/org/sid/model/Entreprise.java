package org.sid.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Entreprise")
public class Entreprise extends AbstractEntity{

	@Column(name = "nom")
	private String nom;

	@Column(name = "description")
	private String description;
	@Embedded
	private Adresses adresse;
	
	@Column(name = "codefiscale")
	private String codeFiscale;
	
	@Column(name = "photo")
	private String photo;

	@Column(name = "email")
	private String email;

	@Column(name = "numtel")
	private String numTel;
	
	@Column(name = "siteweb")
	private String siteWeb;
	@OneToMany(mappedBy = "entreprise")
	private List<Utlisateurs> utlisateurs;
}
