/**
 * 
 */
package com.backend.dto;

import java.io.Serializable;

/**
 * @author m.bouabid
 *
 */
public class FileDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6280108736757688771L;

	
	
	private Long id;

	private String label;

	private String name;

	private Long plageHoraire;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPlageHoraire() {
		return plageHoraire;
	}

	public void setPlageHoraire(Long plageHoraire) {
		this.plageHoraire = plageHoraire;
	}
	
	
	
}
