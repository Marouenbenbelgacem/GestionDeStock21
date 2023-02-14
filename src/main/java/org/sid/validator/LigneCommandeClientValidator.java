package org.sid.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.dto.LigneCommandeClientDto;

public class LigneCommandeClientValidator {
	public static List<String> validate(LigneCommandeClientDto ligneComCltDto) {
		List<String> errors = new ArrayList<String>();
		if (ligneComCltDto == null) {
			errors.add("veuillez saisir l'article");
			errors.add("veuillez saisir la commande de l'client");
			errors.add("veuillez saisir la quantite de l'article");
			errors.add("veuillez saisir le prix Unitaire de l'article");
			return errors;

		}
		
		if (ligneComCltDto.getArticle() == null) {
			errors.add("veuillez saisir l'article");
		}
		if (ligneComCltDto.getCommandeClient()== null) {
			errors.add("veuillez saisir la commande de l'client");
		}
		if (ligneComCltDto.getQuantite()== null) {
			errors.add("veuillez saisir la quantite de l'article");
		}
		if (ligneComCltDto.getPrixUnitaire()== null) {
			errors.add("veuillez saisir le prix Unitaire de l'article");
		}
		return errors;
}
}