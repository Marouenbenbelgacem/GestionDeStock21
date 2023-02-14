package org.sid.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Utlisateur")
public class Utlisateurs extends AbstractEntity {

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String preNom;
	@Column(name = "email")
	private String email;
	@Column(name = "dateenaissance")
	private Instant dateDeNaissance;
	@Column(name = "motdepass")
	private String motDePass;
	@Embedded
	private Adresses adresse; // chaamp compose on va l'utlise plusieur fois

	@Column(name = "photo")
	private String photo;
	@ManyToOne
	@JoinColumn(name = "ideentreprise")
	private Entreprise entreprise;
	
	@OneToMany(mappedBy = "utlisateur")
	private List<Roles> roles;

}
