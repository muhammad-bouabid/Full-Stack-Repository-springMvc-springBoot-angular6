/**
 * 
 */
package com.backend.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author m.BOUABID
 *
 */
@Entity
@Table(name = "PHONE")
public class Phone implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2640168942897010922L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "LABEL")
	private String label;

	@Column(name = "PHONE_NUMBER")
	private Integer phoneNumber;

	@Column(name = "TIME_OUT")
	private Integer timeOut;

//	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLAGE_ID")
	private PlageHoraire plageHoraire;

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

	public PlageHoraire getPlageHoraire() {
		return plageHoraire;
	}

	public void setPlageHoraire(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	}

}
