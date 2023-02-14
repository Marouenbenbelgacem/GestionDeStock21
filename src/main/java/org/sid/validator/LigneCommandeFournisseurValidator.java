package org.sid.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.dto.LigneCommandeClientDto;
import org.sid.dto.LigneCommandeFournisseurDto;

public class LigneCommandeFournisseurValidator {
	public static List<String> validate(LigneCommandeFournisseurDto ligneComFouDto) {

	List<String> errors = new ArrayList<String>();
	if (ligneComFouDto == null) {
		errors.add("veuillez saisir l'article");
		errors.add("veuillez saisir la commande de Fournisseur");
		errors.add("veuillez saisir la quantite de Fournisseur");
		errors.add("veuillez saisir le prix Unitaire de l'article");
		return errors;

	}
	
	if (ligneComFouDto.getArticle() == null) {
		errors.add("veuillez saisir l'article");
	}
	if (ligneComFouDto.getCommandeFournissuer()== null) {
		errors.add("veuillez saisir la commande de Fournisseur");
	}
	if (ligneComFouDto.getQuantite()== null) {
		errors.add("veuillez saisir la quantite pour Fournisseur");
	}
	if (ligneComFouDto.getPrixUnitaire()== null) {
		errors.add("veuillez saisir le prix Unitaire de l'article");
	}
	return errors;
}
}
