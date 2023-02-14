package org.sid.model;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "LigneVente")
public class LigneVente extends AbstractEntity {
	@Column(name = "idEntreprise")
	private Integer idEntreprise;
	@ManyToOne
	@JoinColumn(name = "idavente")
	private Ventes vente;

	@Column(name = "quantite")
	private BigDecimal quantite;

	@Column(name = "prixunitaire")
	private BigDecimal prixUnitaire;

	
}
