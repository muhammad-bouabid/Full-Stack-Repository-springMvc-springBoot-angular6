package com.backend.dto.light;

import java.io.Serializable;

/**
 * @author m.bouabid
 *
 */
public class FileLightDto extends FileLightCreationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6280108736757688771L;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
