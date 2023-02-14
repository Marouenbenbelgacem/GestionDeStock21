package org.sid.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Roles")
public class Roles extends AbstractEntity{
	@Column(name = "idEntreprise")
	private Integer idEntreprise;
	@Column(name = "Rolename")
	private String RoleName;
	
	@ManyToOne
	@JoinColumn(name = "idutlisateur")
	private Utlisateurs utlisateur;

}
