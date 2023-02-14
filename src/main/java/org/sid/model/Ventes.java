package org.sid.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
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
@Table(name = "Ventes")
public class Ventes extends AbstractEntity{
	@Column(name = "idEntreprise")
	private Integer idEntreprise;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "datevente")
	private Instant dateVente;
	
	@Column(name = "commentaire")
	private String commentaire;
	@OneToMany (mappedBy = "vente")
	private List<LigneVente> ligneVentes; 
}
