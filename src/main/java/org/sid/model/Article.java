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
@Table(name = "Article")
public class Article extends AbstractEntity {
	
	@Column(name = "idEntreprise")
	private Integer idEntreprise;
	@Column(name = "codearticle")
	private String codeArticle;

	@Column(name = "description")
	private String description;

	@Column(name = "prixunitaireht")
	private BigDecimal prixUnitaireHt;

	@Column(name = "tauxtva")
	private BigDecimal tauxTva;

	@Column(name = "prixunitairetc")
	private BigDecimal prixUnitaireTtc;

	@Column(name = "photo")
	private String photo;

	@ManyToOne
	@JoinColumn(name = "idcategory")
	private Category category;

}
