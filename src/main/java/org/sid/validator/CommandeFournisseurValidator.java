package org.sid.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

public class CommandeFournisseurValidator {
	public static List<String> validate(CommandeFournisseurDto commandeFournisseurDto) {
		List<String> errors = new ArrayList<String>();
		
		if (commandeFournisseurDto == null) {
			errors.add("veulliez saisir le Code de la commande");
			errors.add("veulliez saisir la date de la commande");
			errors.add("veulliez saisir le client de la commande");
			errors.add("veulliez saisir les ligne de a commande");
			return errors;

		}
		
		if (!StringUtils.hasLength(commandeFournisseurDto.getCode())) {
			errors.add("veulliez saisir le Code de la commande");
		}
		if (commandeFournisseurDto.getDateCommande() == null) {
			errors.add("veulliez saisir la date de la commande");
		}
		if (commandeFournisseurDto.getFournisseur() == null) {
			errors.add("veulliez saisir le client de la commande");
		}
		if (commandeFournisseurDto.getLigneCommandeFournisseurs() == null) {
			errors.add("veulliez saisir les ligne de a commande");
		}
		return errors;

}
}