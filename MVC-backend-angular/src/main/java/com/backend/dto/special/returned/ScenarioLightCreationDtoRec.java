package com.backend.dto.special.returned;

import java.io.Serializable;

import com.backend.common.enums.TypeScenario;

/**
 * @author m.bouabid
 *
 */
public class ScenarioLightCreationDtoRec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2835611953966232414L;

	private String name;

	private String Language;

	private TypeScenario typeScenario;

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

}