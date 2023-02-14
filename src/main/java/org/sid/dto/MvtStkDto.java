package org.sid.dto;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.sid.model.Article;
import org.sid.model.MvtStk;
import org.sid.model.TypeMvt;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class MvtStkDto {

	private Integer id;

	private ArticleDto article;
	
	private BigDecimal quantite;

	private Instant dateMvt;
	
	private TypeMvt typeMvt;
	
	
	
	public static MvtStkDto fromEntity (MvtStk mvtStk) {
		if (mvtStk == null) {
			return null;
		}
		return MvtStkDto.builder()
				.id(mvtStk.getId())
				.article(ArticleDto.fromEntity(mvtStk.getArticle()))
				.quantite(mvtStk.getQuantite())
				.dateMvt(mvtStk.getDateMvt())
				.typeMvt(mvtStk.getTypeMvt())
				.build();
	}
	public static MvtStk toEntity (MvtStkDto mvtStkDto) {
		if (mvtStkDto == null) {
			return null;
		
		}
		
		MvtStk mvtStk = new MvtStk();
		
		mvtStk.setId(mvtStkDto.getId());
		mvtStk.setArticle(ArticleDto.toEntity(mvtStkDto.getArticle()));
		mvtStk.setQuantite(mvtStkDto.getQuantite());
		mvtStk.setDateMvt(mvtStkDto.getDateMvt());
		mvtStk.setTypeMvt(mvtStkDto.getTypeMvt());
		return mvtStk;
		
	}
	
	
}
