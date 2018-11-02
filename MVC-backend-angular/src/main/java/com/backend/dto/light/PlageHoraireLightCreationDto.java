package com.backend.dto.light;

import java.io.Serializable;
import java.util.Date;

/**
 * @author m.bouabid
 *
 */
public class PlageHoraireLightCreationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2787606099793424710L;

	private Date date;

	private Date startingTime;

	private Date endOfTime;

	private ScenarioLightDto scenario;

	private PhoneLightDto phone;

	private FileLightDto file;

	private Character availability;

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

	public ScenarioLightDto getScenario() {
		return scenario;
	}

	public void setScenario(ScenarioLightDto scenario) {
		this.scenario = scenario;
	}

	public PhoneLightDto getPhone() {
		return phone;
	}

	public void setPhone(PhoneLightDto phone) {
		this.phone = phone;
	}

	public FileLightDto getFile() {
		return file;
	}

	public void setFile(FileLightDto file) {
		this.file = file;
	}

	public Character getAvailability() {
		return availability;
	}

	public void setAvailability(Character availability) {
		this.availability = availability;
	}

}
