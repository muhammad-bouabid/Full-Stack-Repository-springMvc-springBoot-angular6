package com.backend.dto.light;

import java.io.Serializable;

/**
 * @author m.bouabid
 *
 */
public class ScenarioLightDto extends ScenarioLightCreationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2835611953966232414L;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
