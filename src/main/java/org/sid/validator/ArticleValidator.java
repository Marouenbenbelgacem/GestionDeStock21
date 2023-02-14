package org.sid.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.dto.ArticleDto;
import org.springframework.util.StringUtils;

public class ArticleValidator {

public static List<String> validate (ArticleDto articleDto){
		
		List<String> errors = new ArrayList<String>();
		
		if (articleDto == null) {
			errors.add("veulliez saisir le code de l'articel");
			errors.add("veulliez saisir la description de l'articel");
			errors.add("veulliez saisir le Prix Unitaire HT de l'articel");
			errors.add("veulliez saisir le TVA de l'articel");
			errors.add("veulliez saisir le Prix Unitaire TTc de l'articel");
			errors.add("veulliez Selectionner une Categorie");
			return errors;

		}
	
	if (!StringUtils.hasLength(articleDto.getCodeArticle())) {
		errors.add("veulliez saisir le code de l'articel");
	}
	if (!StringUtils.hasLength(articleDto.getDescription())) {
		errors.add("veulliez saisir la description de l'articel");
	}
	if (articleDto.getPrixUnitaireHt()== null) {
		errors.add("veulliez saisir le Prix Unitaire HT de l'articel");
	}
	if (articleDto.getTauxTva()==null) {
		errors.add("veulliez saisir le TVA de l'articel");
	}
	if (articleDto.getPrixUnitaireTtc() == null) {
		errors.add("veulliez saisir le Prix Unitaire TTc de l'articel");
	}
	if (articleDto.getCategory() == null) {
		errors.add("veulliez Selectionner une Categorie");
	} 
	return errors;
}
}