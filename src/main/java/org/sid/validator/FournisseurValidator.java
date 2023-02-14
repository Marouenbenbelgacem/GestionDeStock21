package org.sid.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.dto.FournisseurDto;
import org.springframework.util.StringUtils;

public class FournisseurValidator {

public static List<String> validate (FournisseurDto fournisseurDto){
	List<String> errors = new ArrayList<String>();

	if (fournisseurDto == null) {
		errors.add("veulliez saisir le nom de Fournisseur");
		errors.add("veulliez saisir le Prenom de Fournisseur");
		errors.add("veulliez saisir l'Email de Fournisseur");
		errors.add("veulliez saisir le Numero de Tel de Fournisseur");
		return errors;

	}
	if (!StringUtils.hasLength(fournisseurDto.getNom())) {
		errors.add("veulliez saisir le nom de Fournisseur");
	}
	if (!StringUtils.hasLength(fournisseurDto.getPreNom())) {
		errors.add("veulliez saisir le Prenom de Fournisseur");
	}
	if (!StringUtils.hasLength(fournisseurDto.getEmail())) {
		errors.add("veulliez saisir l'Email de Fournisseur");
	}
	if (!StringUtils.hasLength(fournisseurDto.getNumTel())) {
		errors.add("veulliez saisir le Numero de Tel de Fournisseur");
	}
	
	return errors;

}}
