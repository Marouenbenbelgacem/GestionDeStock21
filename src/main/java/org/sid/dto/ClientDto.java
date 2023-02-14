package org.sid.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;

import org.sid.model.Adresses;
import org.sid.model.Client;
import org.sid.model.CommandeClient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {

	private Integer id;

	private String nom;

	private String preNom;

	private AdressesDto adresse;

	private String email;

	private String photo;

	private String numTel;
@JsonIgnore
	private List<CommandeClientDto> commandeClients;

	public static ClientDto fromEntity(Client client) {
		if (client == null) {
			return null;
		}
		return ClientDto.builder()
				.id(client.getId())
				.nom(client.getNom())
				.preNom(client.getPreNom())
				.adresse(AdressesDto.fromEntity(client.getAdresse()))
				.email(client.getEmail())
				.photo(client.getPhoto())
				.numTel(client.getNumTel())
				//.commandeClients(CommandeClientDto.fromEntity(client.getCommandeClients()))
				.build();
	}

	public static Client toEntity(ClientDto clientDto) {
		if (clientDto == null) {
			return null;
		}

		Client client = new Client();
		client.setId(clientDto.getId());
		client.setNom(clientDto.getNom());
		client.setPreNom(clientDto.getPreNom());
		client.setAdresse(AdressesDto.toEntity(clientDto.getAdresse()));
		client.setEmail(clientDto.getEmail());
		client.setPhoto(clientDto.getPhoto());
		client.setNumTel(clientDto.getNumTel());
		//client.setCommandeClients(CommandeClientDto.toEntity(clientDto.getCommandeClients()));
return client;
	}

}
