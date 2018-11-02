package com.backend.dto.light;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.backend.common.enums.TypeScenario;
import com.backend.dto.PlageHoraireDto;

/**
 * @author m.bouabid
 *
 */
public class ScenarioLightCreationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2835611953966232414L;

	private String name;

	private String Language;

	private TypeScenario typeScenario;

	private Set<PlageHoraireDto> plageHoraires = new HashSet<PlageHoraireDto>();

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
