/**
 * 
 */
package com.backend.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.backend.common.enums.TypeScenario;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author m.bouabid
 *
 */
public class ScenarioDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2835611953966232414L;

	private Long id;

	private String name;

	private String Language;

	private TypeScenario typeScenario;

	@JsonIgnore
	private Set<PlageHoraireDto> plageHoraires = new HashSet<PlageHoraireDto>();

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

	public Set<PlageHoraireDto> getPlageHoraires() {
		return plageHoraires;
	}

	public void setPlageHoraires(Set<PlageHoraireDto> plageHoraires) {
		this.plageHoraires = plageHoraires;
	}

}
