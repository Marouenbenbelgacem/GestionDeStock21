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
@Entity
@NoArgsConstructor

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Table(name = "Fournisseur")
public class Fournisseur extends AbstractEntity{
	@Column(name = "idEntreprise", insertable = false, updatable = false)
	private Integer idEntreprise;
	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String preNom;
	@Embedded
	private Adresses adresse; // chaamp compose on va l'utlise plusieur fois

	@Column(name = "email")
	private String email;

	@Column(name = "photo")
	private String photo;

	@Column(name = "numTel")
	private String numTel;
	@OneToMany(mappedBy = "fournisseur")
	private List<CommandeFournisseur> commandeFournisseurs;

}
