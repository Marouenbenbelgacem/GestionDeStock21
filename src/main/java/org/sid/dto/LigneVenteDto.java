package org.sid.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.sid.model.Article;
import org.sid.model.LigneVente;
import org.sid.model.Ventes;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class LigneVenteDto {
	private Integer id;

	private VentesDto ventes;
	private Article article;

	@Column(name = "quantite")
	private BigDecimal quantite;

	@Column(name = "prixunitaire")
	private BigDecimal prixUnitaire;
	
	
	
	
	public static LigneVenteDto fromEntity (LigneVente ligneVente) {
		if (ligneVente==null) {
			return null;
		}
		return LigneVenteDto.builder()
				.id(ligneVente.getId())
				.ventes(VentesDto.fromEntity(ligneVente.getVente()))
				.quantite(ligneVente.getQuantite())
				.prixUnitaire(ligneVente.getPrixUnitaire())
				.build();
	}
	public static LigneVente toEntity (LigneVenteDto ligneVenteDto) {
		if (ligneVenteDto == null) {
			return null;
		}
		LigneVente ligneVente = new LigneVente();
		ligneVente.setId(ligneVenteDto.getId());
		ligneVente.setVente(VentesDto.toEntity(ligneVenteDto.getVentes()));
		ligneVente.setQuantite(ligneVenteDto.getQuantite());
		ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
		return ligneVente;

	}
}
