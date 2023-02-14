package org.sid.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.dto.CommandeClientDto;
import org.sid.dto.FournisseurDto;
import org.springframework.util.StringUtils;

public class CommandeClientValidator {
	public static List<String> validate(CommandeClientDto commandeClientDto) {
		List<String> errors = new ArrayList<String>();
		
		if (commandeClientDto == null) {
			errors.add("veulliez saisir le Code de la commande");
			errors.add("veulliez saisir la date de la commande");
			errors.add("veulliez saisir le client de la commande");
			return errors;
		}

		if (!StringUtils.hasLength(commandeClientDto.getCode())) {
			errors.add("veulliez saisir le Code de la commande");
		}
		if (commandeClientDto.getDateCommande() == null) {
			errors.add("veulliez saisir la date de la commande");
		}
		if (commandeClientDto.getClient() == null) {
			errors.add("veulliez saisir le client de la commande");
		}

		return errors;

	}
}