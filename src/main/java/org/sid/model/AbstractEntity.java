package org.sid.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) //cette annotation va automatiqement ecouter cette class et a chaque fois elle trouve creationDate et LastmodifiedDate va foire mettre a jours ces champ dans la base de donne  

public class AbstractEntity implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@CreatedDate
	@Column(name = "creationDate",nullable = false, updatable = false)
	private Instant creationDate;
	
	@LastModifiedDate
	@Column(name = "lastModifiedDate")
	private Instant lastModifiedDate;
	
	
	

}
