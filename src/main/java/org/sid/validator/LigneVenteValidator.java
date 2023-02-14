package org.sid.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.dto.LigneVenteDto;

public class LigneVenteValidator {
	public static List<String> validate(LigneVenteDto ligneVenteDto) {
		List<String> errors = new ArrayList<String>();
		
		if (ligneVenteDto == null) {
			errors.add("veuillez mentionner les Ventes");
			errors.add("veuillez saisir le Prix Unitaire");
			errors.add("veuillez saisir la quanitite");
			return errors;		
		}
		
		if (ligneVenteDto.getVentes() == null) {
			errors.add("veuillez mentionner les Ventes");
		}
		if (ligneVenteDto.getPrixUnitaire() == null) {
			errors.add("veuillez saisir le Prix Unitaire");
		}
		if (ligneVenteDto.getQuantite() == null) {
			errors.add("veuillez saisir la quanitite");
		}
		return errors;		
}
}