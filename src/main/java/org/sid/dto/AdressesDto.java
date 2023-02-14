package org.sid.dto;

import javax.persistence.Column;

import org.sid.model.Adresses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdressesDto {
	private Integer id;

	private String adresse1;

	private String adresse2;

	private String Ville;

	private String codePostale;

	private String paye;

	public static AdressesDto fromEntity(Adresses adresses) {
		if (adresses == null) {
			return null;
			// todo exception
		}
		return AdressesDto.builder()
				.adresse1(adresses.getAdresse1())
				.adresse2(adresses.getAdresse2())
				.codePostale(adresses.getCodePostale())
				.Ville(adresses.getVille())
				.paye(adresses.getPaye())
				.build();
	}

	public static Adresses toEntity(AdressesDto adressesDto) {
		if (adressesDto == null) {
			return null;
			// todo exception
		}
		Adresses adresses = new Adresses();
		adresses.setAdresse1(adressesDto.getAdresse1());
		adresses.setAdresse2(adressesDto.getAdresse2());
		adresses.setCodePostale(adressesDto.getCodePostale());
		adresses.setVille(adressesDto.getVille());
		adresses.setPaye(adressesDto.getPaye());

		return adresses;
	}

}
