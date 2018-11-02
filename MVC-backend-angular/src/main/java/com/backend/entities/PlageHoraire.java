/**
 * 
 */
package com.backend.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author m.BOUABID
 *
 */
@Entity
@Table(name = "PLAGE_HORAIRE")
public class PlageHoraire implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5868367485906176487L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "DATE")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "STARTING_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startingTime;

	@Column(name = "END_OF_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endOfTime;

	@ManyToOne(fetch = FetchType.LAZY)
//	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCENARIO_ID")
	private Scenario scenario;

//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "plageHoraire")
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "plageHoraire", cascade = CascadeType.REMOVE)
	private Phone phone;

//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "plageHoraire")
	@OneToOne(fetch = FetchType.LAZY ,mappedBy="plageHoraire", cascade = CascadeType.REMOVE)
	private File file;

	@Column(name = "PF", length = 1)
	private Character availability;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(Date startingTime) {
		this.startingTime = startingTime;
	}

	public Date getEndOfTime() {
		return endOfTime;
	}

	public void setEndOfTime(Date endOfTime) {
		this.endOfTime = endOfTime;
	}

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Character getAvailability() {
		return availability;
	}

	public void setAvailability(Character availability) {
		this.availability = availability;
	}

}
