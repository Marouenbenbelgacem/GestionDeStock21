package org.sid.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.sid.model.Roles;
import org.sid.model.Utlisateurs;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class RolesDto {
	private Integer id;
	private String roleName;
	private UtlisateursDto utlisateur;

	public static RolesDto fromEntity (Roles roles) {
		if (roles == null) {
			return null;
		}
		return RolesDto.builder()
				.id(roles.getId())
				.roleName(roles.getRoleName())
				.utlisateur(UtlisateursDto.fromEntity(roles.getUtlisateur()))
				.build();
		
	}
	public static Roles toEntity (RolesDto rolesDto) {
		if (rolesDto == null) {
			return null;
		}
		Roles roles = new Roles();
		roles.setId(rolesDto.getId());
		roles.setRoleName(rolesDto.getRoleName());
		roles.setUtlisateur(UtlisateursDto.toEntity(rolesDto.getUtlisateur()));
		return roles;
		
	}
	
}
