/**
 * 
 */
package com.backend.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.backend.common.enums.TypeScenario;

/**
 * @author m.BOUABID
 *
 */
@Entity
@Table(name = "SCENARIO")
public class Scenario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5279894799498427027L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "SCENARIO_NAME")
	private String name;

	@Column(name = "LANGUE")
	private String Language;

	@Column(name = "SCENARIO_TYPE")
	@Enumerated(EnumType.STRING)
	private TypeScenario typeScenario;

	@OneToMany(mappedBy = "scenario", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
	private Set<PlageHoraire> plageHoraires = new HashSet<PlageHoraire>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public TypeScenario getTypeScenario() {
		return typeScenario;
	}

	public void setTypeScenario(TypeScenario typeScenario) {
		this.typeScenario = typeScenario;
	}

	public Set<PlageHoraire> getPlageHoraires() {
		return plageHoraires;
	}

	public void setPlageHoraires(Set<PlageHoraire> plageHoraires) {
		this.plageHoraires = plageHoraires;
	}

}
