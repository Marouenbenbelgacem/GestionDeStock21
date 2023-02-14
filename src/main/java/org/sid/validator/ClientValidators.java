package org.sid.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.dto.ArticleDto;
import org.sid.dto.ClientDto;
import org.springframework.util.StringUtils;

public class ClientValidators {

public static List<String> validate (ClientDto clientDto){
		
		List<String> errors = new ArrayList<String>();
		if (clientDto == null) {
			errors.add("veulliez saisir le nom de Client");
			errors.add("veulliez saisir le Prenom de Client");
			errors.add("veulliez saisir l'Email de Client");
			errors.add("veulliez saisir le Numero de Tel de Client");
			return errors;

		}
		if (!StringUtils.hasLength(clientDto.getNom())) {
			errors.add("veulliez saisir le nom de Client");
		}
		if (!StringUtils.hasLength(clientDto.getPreNom())) {
			errors.add("veulliez saisir le Prenom de Client");
		}
		if (!StringUtils.hasLength(clientDto.getEmail())) {
			errors.add("veulliez saisir l'Email de Client");
		}
		if (!StringUtils.hasLength(clientDto.getNumTel())) {
			errors.add("veulliez saisir le Numero de Tel de Client");
		}
		
		return errors;
}
}