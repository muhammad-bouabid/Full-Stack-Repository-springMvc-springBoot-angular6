package com.backend.dto.special.returned;

import java.io.Serializable;
import java.util.Date;

/**
 * @author m.bouabid
 *
 */
public class PlageHoraireLightDtoRec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2787606099793424710L;

	private Long id;

	private Date date;

	private Date startingTime;

	private Date endOfTime;

	private ScenarioLightCreationDtoRec scenario;

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

	public ScenarioLightCreationDtoRec getScenario() {
		return scenario;
	}

	public void setScenario(ScenarioLightCreationDtoRec scenario) {
		this.scenario = scenario;
	}

	public Character getAvailability() {
		return availability;
	}

	public void setAvailability(Character availability) {
		this.availability = availability;
	}

}
