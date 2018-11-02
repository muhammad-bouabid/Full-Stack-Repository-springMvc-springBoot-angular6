package com.backend.dto.special.returned;

import java.io.Serializable;

import com.backend.common.enums.TypeScenario;

/**
 * @author m.bouabid
 *
 */
public class ScenarioLightSpecialDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2835611953966232414L;

	private Long id;

	private String name;

	private String language;

	private TypeScenario typeScenario;

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
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public TypeScenario getTypeScenario() {
		return typeScenario;
	}

	public void setTypeScenario(TypeScenario typeScenario) {
		this.typeScenario = typeScenario;
	}

}