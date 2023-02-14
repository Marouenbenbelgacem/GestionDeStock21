package org.sid.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.sid.model.Article;
import org.sid.model.CommandeFournisseur;
import org.sid.model.LigneCommandeClient;
import org.sid.model.LigneCommandeFournisseur;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class LigneCommandeFournisseurDto {

	private Integer id;
	private ArticleDto article;
	private CommandeFournisseurDto commandeFournissuer;
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;
	
	
public static LigneCommandeFournisseurDto fromEntity (LigneCommandeFournisseur ligneCommandeFournisseur) {
		
		if (ligneCommandeFournisseur == null) {
			return null;
		}
		return LigneCommandeFournisseurDto.builder()
				.id(ligneCommandeFournisseur.getId())
				.article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
				//.commandeFournissuer(CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandeFournisseur())
				.quantite(ligneCommandeFournisseur.getQuantite())
				.prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
				.build();
	}
	public static LigneCommandeFournisseur toEntity (LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
		if (ligneCommandeFournisseurDto == null) {
			return null;
		}
		LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
		ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
		ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(ligneCommandeFournisseurDto.getArticle()));
		//ligneCommandeFournisseur.setCommandeFournissuer(CommandeFournisseurDto.toEntity(ligneCommandeFournisseurDto.getCommandeFournissuer()));
		ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseurDto.getQuantite());
		ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.getPrixUnitaire());
	
		return ligneCommandeFournisseur;
	}
}

