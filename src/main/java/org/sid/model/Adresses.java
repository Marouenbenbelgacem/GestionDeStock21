package org.sid.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Adresses implements Serializable {
	@Column(name = "idEntreprise")
	private Integer idEntreprise;

	@Column(name = "adresse1")
	private String adresse1;
	
	@Column(name = "adresse2")
	private String adresse2;
	
	@Column(name = "Ville")
	private String Ville;
	
	@Column(name = "codePostale")
	private String codePostale;
	
	@Column(name = "paye")
	private String paye;

}
