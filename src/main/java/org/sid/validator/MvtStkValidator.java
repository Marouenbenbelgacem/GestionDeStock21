package org.sid.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.dto.MvtStkDto;

public class MvtStkValidator {
	
	public static List<String> validate(MvtStkDto mvtStkDto) {
		List<String> errors = new ArrayList<String>();
		if (mvtStkDto == null) {
			errors.add("Veuillez saisir l'article");
			errors.add("Veuillez saisir la quantite dans cette mouvement");
			errors.add("Veuillez saisir la date de la mouvement de stock");
			errors.add("Veuillez saisir le Type de muvement de stock");
			return errors;

		}
		if (mvtStkDto.getArticle() == null ) {
			errors.add("Veuillez saisir l'article");
		}
		if (mvtStkDto.getQuantite() == null ) {
			errors.add("Veuillez saisir la quantite dans cette mouvement");
		}
		if (mvtStkDto.getDateMvt() == null ) {
			errors.add("Veuillez saisir la date de la mouvement de stock");
		}
		if (mvtStkDto.getTypeMvt()== null) {
			errors.add("Veuillez saisir le Type de muvement de stock");
		}
return errors;
}
}