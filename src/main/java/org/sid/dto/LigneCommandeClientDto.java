package org.sid.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.sid.model.Article;
import org.sid.model.CommandeClient;
import org.sid.model.Fournisseur;
import org.sid.model.LigneCommandeClient;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class LigneCommandeClientDto {
	private Integer id;
	private ArticleDto article;
	private CommandeClientDto commandeClient;
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;
	
	
public static LigneCommandeClientDto fromEntity (LigneCommandeClient ligneCommandeClient) {
		
		if (ligneCommandeClient == null) {
			return null;
		}
		return LigneCommandeClientDto.builder()
				.id(ligneCommandeClient.getId())
				.article(ArticleDto.fromEntity(ligneCommandeClient.getArticle()))
				//.commandeClient(CommandeClientDto.fromEntity(ligneCommandeClient.getCommandeClient()))
				.quantite(ligneCommandeClient.getQuantite())
				.prixUnitaire(ligneCommandeClient.getPrixUnitaire())
				.build();
	}
	public static LigneCommandeClient toEntity (LigneCommandeClientDto ligneCommandeClientDto) {
		if (ligneCommandeClientDto == null) {
			return null;
		}
		LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
		ligneCommandeClient.setId(ligneCommandeClientDto.getId());
		ligneCommandeClient.setArticle(ArticleDto.toEntity(ligneCommandeClientDto.getArticle()));
		//ligneCommandeClient.setCommandeClient(CommandeClientDto.toEntity(ligneCommandeClientDto.getCommandeClient()));
		ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
		ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());
	
		return ligneCommandeClient;
	}
}
