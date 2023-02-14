package org.sid.dto;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.sid.model.Client;
import org.sid.model.CommandeClient;
import org.sid.model.LigneCommandeClient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeClientDto {
	private Integer id;
	private String code;
	private Instant dateCommande;
	private ClientDto client;
	private List<LigneCommandeClientDto> ligneCommandeClients;

	public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
		if (commandeClient == null) {
			return null;
		}
		return CommandeClientDto.builder().id(commandeClient.getId()).code(commandeClient.getCode())
				.dateCommande(commandeClient.getDateCommande()).client(ClientDto.fromEntity(commandeClient.getClient()))
				// .ligneCommandeClients(LigneCommandeClientDto.fromEntity(commandeClient.getLigneCommandeClients()))
				.build();
	}

	public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {
		if (commandeClientDto == null) {
			return null;
		}
		CommandeClient commandeClient = new CommandeClient();
		commandeClient.setId(commandeClient.getId());
		commandeClient.setCode(commandeClient.getCode());
		commandeClient.setDateCommande(commandeClient.getDateCommande());
		commandeClient.setClient(commandeClient.getClient());
		// commandeClient.setLigneCommandeClients(LigneCommandeClientDto.toEntity(commandeClient.getLigneCommandeClients()));
		return commandeClient;
	}

}
