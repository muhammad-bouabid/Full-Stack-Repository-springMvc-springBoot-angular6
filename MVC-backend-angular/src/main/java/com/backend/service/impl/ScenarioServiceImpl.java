package com.backend.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.dto.light.ScenarioLightCreationDto;
import com.backend.dto.light.ScenarioLightDto;
import com.backend.dto.special.returned.ScenarioLightSpecialDto;
import com.backend.entities.Scenario;
import com.backend.repository.ScenarioRepository;
import com.backend.service.ScenarioService;
import com.google.common.reflect.TypeToken;


@Service
@Transactional(readOnly = true)
public class ScenarioServiceImpl implements ScenarioService {
	
	
	@Autowired
	private ScenarioRepository scenarioRepository;
	
	
	@Autowired
	private ModelMapper modelmapper;
	
	
	
	
	@Override
	@SuppressWarnings("serial")
	public List<ScenarioLightSpecialDto> getAllScenarios() {
		List<Scenario> scenarios = scenarioRepository.getAllScenarios();
		Type listType = new TypeToken<List<ScenarioLightSpecialDto>>() {}.getType();
		List<ScenarioLightSpecialDto> sceanriosDto = modelmapper.map(scenarios, listType);
		return sceanriosDto;
	}

	@Override
	public ScenarioLightSpecialDto getScenarioByID(Long id) {
		ScenarioLightSpecialDto scenarioDto = null;
		Scenario scenario = scenarioRepository.getScenarioByID(id);
		if(scenario != null)
			scenarioDto = modelmapper.map(scenario, ScenarioLightSpecialDto.class);
		return scenarioDto;
	}

	@Override
	@Transactional
	public ScenarioLightSpecialDto updateScenario(ScenarioLightDto scenario) {
		Scenario scenarioToUpdate = modelmapper.map(scenario, Scenario.class);
		Scenario updateSenario = scenarioRepository.updateScenario(scenarioToUpdate);
		ScenarioLightSpecialDto scenarioDto = modelmapper.map(updateSenario, ScenarioLightSpecialDto.class);
		return scenarioDto;
	}

	@Override
	@Transactional
	public Boolean deleteScenarioById(Long id) {
		return scenarioRepository.deleteScenarioById(id);
	}

	@Override
	@Transactional
	public ScenarioLightSpecialDto createScenario(ScenarioLightCreationDto scenarioLightCreationDto) {
		Scenario scenarioToCreate = modelmapper.map(scenarioLightCreationDto, Scenario.class);
		Scenario savedSenario = scenarioRepository.createScenario(scenarioToCreate);
		ScenarioLightSpecialDto scenarioDto = modelmapper.map(savedSenario, ScenarioLightSpecialDto.class);
		return scenarioDto;
	}

}
