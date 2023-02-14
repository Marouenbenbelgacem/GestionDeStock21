package org.sid.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

public class EntrepriseValidator {
	public static List<String> validate(EntrepriseDto entrepriseDto) {
		List<String> errors = new ArrayList<String>();

		if (!StringUtils.hasLength(entrepriseDto.getNom())) {
			errors.add("veulliez saisir le nom de l'entreprise");
		}
		if (!StringUtils.hasLength(entrepriseDto.getDescription())) {
			errors.add("veulliez saisir la description de l'entreprise");
		}
		
		if (entrepriseDto.getAdresse() == null) {
			errors.add("veuillez saisir l'adressse !!");
		} else {
			
			if (!StringUtils.hasText(entrepriseDto.getAdresse().getAdresse1())) {
				errors.add("Le champs 'Adress1' est obligatoire");
			}
			if (!StringUtils.hasText(entrepriseDto.getAdresse().getVille())) {
				errors.add("Le champs 'Ville' est obligatoire");
			}
			if (!StringUtils.hasText(entrepriseDto.getAdresse().getCodePostale())) {
				errors.add("Le champs 'Code Postale' est obligatoire");
			}
			if (!StringUtils.hasText(entrepriseDto.getAdresse().getPaye())) {
				errors.add("Le champs 'Pays' est obligatoire");
			}
		}	
		if (!StringUtils.hasLength(entrepriseDto.getCodeFiscale())) {
			errors.add("veulliez saisir le code fiscale de l'entreprise");
		}
		if (!StringUtils.hasLength(entrepriseDto.getEmail())){
			errors.add("veulliez saisir l'email de l'entreprise");
		}
		if (!StringUtils.hasLength(entrepriseDto.getNumTel())) {
			errors.add("veulliez saisir le numero de Tel de l'entreprise");
		}
		
		
		return errors;
		
}
}