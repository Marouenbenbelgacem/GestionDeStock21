package org.sid.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.dto.VentesDto;
import org.springframework.util.StringUtils;

public class VentesValidator {

	public static List<String> validate(VentesDto ventedDto) {
		List<String> errors = new ArrayList<String>();

		if (ventedDto == null) {
			errors.add("veuillez entrer le code de la vente");
			errors.add("veuillez entrer la date de la vente");
			return errors;
		}

		if (StringUtils.hasLength(ventedDto.getCode())) {
			errors.add("veuillez entrer le code de la vente");
		}
		if (ventedDto.getDateVente() == null) {
			errors.add("veuillez entrer la date de la vente");
		}
		return errors;
	}
}
