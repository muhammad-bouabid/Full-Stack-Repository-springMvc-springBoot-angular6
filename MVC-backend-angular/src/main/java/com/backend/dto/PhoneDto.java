/**
 * 
 */
package com.backend.dto;

import java.io.Serializable;

/**
 * @author m.bouabid
 *
 */
public class PhoneDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522073979768281919L;

	private Long id;

	private String label;

	private Integer phoneNumber;

	private Integer timeOut;

	private PlageHoraireDto plageHoraire;

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