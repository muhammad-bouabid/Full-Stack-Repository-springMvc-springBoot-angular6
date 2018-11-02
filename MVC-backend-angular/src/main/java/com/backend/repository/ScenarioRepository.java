/**
 * 
 */
package com.backend.repository;

import java.util.List;

import com.backend.entities.Scenario;

/**
 * @author m.BOUABID
 *
 */
public interface ScenarioRepository {
	
	/**
	 * get all Scenarios
	 * 
	 * @return
	 */
	List<Scenario> getAllScenarios();

	/**
	 * get Scenario by its id
	 * 
	 * @param id
	 * @return
	 */
	Scenario getScenarioByID(Long id);

	/**
	 * update Scenario
	 * 
	 * @param scenario
	 * @return
	 */
	Scenario updateScenario(Scenario scenario);

	/**
	 * Delete Scenario by its ID
	 * 
	 * @param id
	 */
	Boolean deleteScenarioById(Long id);

	/**
	 * creation new Scenario
	 * 
	 * @param scenarioLightCreationDto
	 * @return
	 */
	Scenario createScenario(Scenario scenario);
}
