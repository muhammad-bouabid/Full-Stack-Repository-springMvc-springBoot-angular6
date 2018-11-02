package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.light.ScenarioLightCreationDto;
import com.backend.dto.light.ScenarioLightDto;
import com.backend.dto.message.MessageDto;
import com.backend.dto.special.returned.ScenarioLightSpecialDto;
import com.backend.service.ScenarioService;



/**
 * @author m.BOUABID
 *
 */
@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ScenarioController {

	@Autowired
	private ScenarioService scenarioService;
	
	
	@RequestMapping(value = "/scenarios", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllScenarios() {
		List<ScenarioLightSpecialDto> scenario = scenarioService.getAllScenarios();
		return ResponseEntity.status(HttpStatus.OK).body(scenario);
	}
	
	
	@RequestMapping(value = "/scenarios/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getScenarioById(@PathVariable Long id) {
		ScenarioLightSpecialDto scenario = scenarioService.getScenarioByID(id);
		if(scenario != null)
			return ResponseEntity.status(HttpStatus.OK).body(scenario);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(scenario);
	}
	
	@RequestMapping(value = "/scenarios/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateScenario(@RequestBody ScenarioLightDto scenario) {
		ScenarioLightSpecialDto scenariodto = scenarioService.updateScenario(scenario);
		if(scenariodto != null)
			return ResponseEntity.status(HttpStatus.OK).body(scenariodto);
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
	}
	
	@RequestMapping(value = "/scenarios", method = RequestMethod.POST)
	public ResponseEntity<Object> createScenario(@RequestBody ScenarioLightCreationDto scenarioLightCreationDto) {
		ScenarioLightSpecialDto scenario = scenarioService.createScenario(scenarioLightCreationDto);
		if(scenario != null)
			return ResponseEntity.status(HttpStatus.OK).body(scenario);
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
	}
	
	
	@RequestMapping(value = "/scenarios/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteScenario(@PathVariable Long id) {
		Boolean deleteStatus = scenarioService.deleteScenarioById(id);
		if(deleteStatus)
			return ResponseEntity.status(HttpStatus.OK).body(new MessageDto("DELETE IS DONE"));
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new MessageDto("DELETE IS DONE"));
	}
}