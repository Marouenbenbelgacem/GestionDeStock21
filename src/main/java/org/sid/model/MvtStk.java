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
@Table(name = "MvtStk")
public class MvtStk extends AbstractEntity{
	@Column(name = "idEntreprise")
	private Integer idEntreprise;
	@ManyToOne
	@JoinColumn(name = "idarticle")
	private Article article;
	
	@Column(name = "quantite")
	private BigDecimal quantite;

	@Column(name = "datemvt")
	private Instant dateMvt;
	
	@Column(name = "typemvt")
	private TypeMvt typeMvt;
}
