package com.backend.dto.light;

import java.io.Serializable;

import com.backend.dto.PlageHoraireDto;

/**
 * @author m.bouabid
 *
 */
public class FileLightCreationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6280108736757688771L;

	private String label;

	private String name;

	private PlageHoraireDto plageHoraire;

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

	public PlageHoraireDto getPlageHoraire() {
		return plageHoraire;
	}

	public void setPlageHoraire(PlageHoraireDto plageHoraire) {
		this.plageHoraire = plageHoraire;
	}

}
