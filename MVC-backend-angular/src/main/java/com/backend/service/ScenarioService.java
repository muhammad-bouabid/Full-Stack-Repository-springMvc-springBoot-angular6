/**
 * 
 */
package com.backend.service;

import java.util.List;
import com.backend.dto.light.ScenarioLightCreationDto;
import com.backend.dto.light.ScenarioLightDto;
import com.backend.dto.special.returned.ScenarioLightSpecialDto;


/**
 * @author m.BOUABID
 *
 */
public interface ScenarioService {
	/**
	 * get all Scenarios
	 * 
	 * @return
	 */
	List<ScenarioLightSpecialDto> getAllScenarios();

	/**
	 * get Scenario by its id
	 * 
	 * @param id
	 * @return
	 */
	ScenarioLightSpecialDto getScenarioByID(Long id);

	/**
	 * update Scenario
	 * 
	 * @param scenario
	 * @return
	 */
	ScenarioLightSpecialDto updateScenario(ScenarioLightDto scenario);

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
	ScenarioLightSpecialDto createScenario(ScenarioLightCreationDto scenarioLightCreationDto);
}
