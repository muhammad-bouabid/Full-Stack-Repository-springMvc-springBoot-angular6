package com.backend.dto.light;

import java.io.Serializable;

import com.backend.dto.PlageHoraireDto;

/**
 * @author m.bouabid
 *
 */
public class PhoneLightCreationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522073979768281919L;

	private String label;

	private Integer phoneNumber;

	private Integer timeOut;

	private PlageHoraireDto plageHoraire;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}

	public PlageHoraireDto getPlageHoraire() {
		return plageHoraire;
	}

	public void setPlageHoraire(PlageHoraireDto plageHoraire) {
		this.plageHoraire = plageHoraire;
	}

}