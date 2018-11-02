package com.backend.dto.light;

import java.io.Serializable;

/**
 * @author m.bouabid
 *
 */
public class PhoneLightDto extends PhoneLightCreationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522073979768281919L;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}