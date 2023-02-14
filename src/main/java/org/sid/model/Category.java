package org.sid.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@Table(name = "Category")
public class Category extends AbstractEntity {
	
	
	
	@Column(name = "idEntreprise")
	private Integer idEntreprise;
	
	@Column(name = "codeCategory")
	private String codeCategory;

	@Column(name = "designation")
	private String designation;

	@OneToMany(mappedBy = "category")
	private List<Article> articles;

}
