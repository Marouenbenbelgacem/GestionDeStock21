package org.sid.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.dto.CategoryDto;
import org.sid.dto.UtlisateursDto;
import org.springframework.util.StringUtils;

public class UtlisateursValidator {

	public static List<String> validate (UtlisateursDto utlisateursDto){
		
		List<String> errors = new ArrayList<String>();
		
		if (utlisateursDto == null ) {
			errors.add("veuillez saisir le nom !!");
			errors.add("veuillez saisir le Prenom !!");
			errors.add("veuillez saisir le Mot De Pass !!");
			errors.add("veuillez saisir l'adressse !!");
			return errors;

		}
	
		if (!StringUtils.hasText(utlisateursDto.getNom())) {
			errors.add("veuillez saisir le nom !!");
		}
		if (!StringUtils.hasLength(utlisateursDto.getPreNom())) {
			errors.add("veuillez saisir le Prenom !!");
		}
		if (!StringUtils.hasLength(utlisateursDto.getEmail())) {
			errors.add("veuillez l'email le Prenom !!");
		}
		if (!StringUtils.hasText(utlisateursDto.getMotDePass())) {
			errors.add("veuillez saisir le Mot De Pass !!");
		}
		if (utlisateursDto.getDateDeNaissance() == null) {
			errors.add("veuillez saisir la date de naissance de l'utlisateur!!");
		}
		if (utlisateursDto.getAdresse() == null) {
			errors.add("veuillez saisir l'adressse !!");
		} else {
			
			if (!StringUtils.hasText(utlisateursDto.getAdresse().getAdresse1())) {
				errors.add("Le champs 'Adress1' est obligatoire");
			}
			if (!StringUtils.hasText(utlisateursDto.getAdresse().getVille())) {
				errors.add("Le champs 'Ville' est obligatoire");
			}
			if (!StringUtils.hasText(utlisateursDto.getAdresse().getCodePostale())) {
				errors.add("Le champs 'Code Postale' est obligatoire");
			}
			if (!StringUtils.hasText(utlisateursDto.getAdresse().getPaye())) {
				errors.add("Le champs 'Pays' est obligatoire");
			}
		}
		
		
		return errors ;

}
}