package org.sid.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.dto.RolesDto;
import org.springframework.util.StringUtils;

public class RolesValidator {
public static List<String> validate (RolesDto rolesDto){
	List<String> errors = new ArrayList<String>();
	if (rolesDto == null) {
		errors.add("veulliez saisir le role SVP");
		errors.add("veulliez saisir l'utlisteur");
		return errors;	
	}
	
	if (!StringUtils.hasLength(rolesDto.getRoleName())) {
		errors.add("veulliez saisir le role SVP");
	}
	if (rolesDto.getUtlisateur() == null) {
		errors.add("veulliez saisir l'utlisteur");
	}
	return errors;
}
}