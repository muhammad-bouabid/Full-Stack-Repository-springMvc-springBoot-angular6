package com.backend.dto.light;

import java.io.Serializable;

/**
 * @author m.bouabid
 *
 */
public class PlageHoraireLightDto extends PlageHoraireLightCreationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2787606099793424710L;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
