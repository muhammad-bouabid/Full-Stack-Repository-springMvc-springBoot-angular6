package com.backend.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.dto.light.PlageHoraireLightCreationDto;
import com.backend.dto.light.PlageHoraireLightDto;
import com.backend.dto.special.returned.PlageHoraireLightDtoRec;
import com.backend.entities.PlageHoraire;
import com.backend.repository.PlageHoraireRepository;
import com.backend.service.PlageHoraireService;
import com.google.common.reflect.TypeToken;


@Service
@Transactional(readOnly = true)
public class PlageHoraireServiceImpl implements PlageHoraireService {

	@Autowired
	private PlageHoraireRepository plageRepository;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	@SuppressWarnings("serial")
	public List<PlageHoraireLightDtoRec> getAllPlageHoraires() {
		List<PlageHoraire> plages = plageRepository.getAllPlageHoraires();
		Type listType = new TypeToken<List<PlageHoraireLightDtoRec>>() {}.getType();
		List<PlageHoraireLightDtoRec> plagesDto = modelmapper.map(plages, listType);
		return plagesDto;
	}

	@Override
	public PlageHoraireLightDtoRec getPlageHoraireByID(Long id) {
		PlageHoraireLightDtoRec plageDto = null;
		PlageHoraire plage = plageRepository.getPlageHoraireByID(id);
		if(plage != null)
			plageDto = modelmapper.map(plage, PlageHoraireLightDtoRec.class);
		return plageDto;
	}

	@Override
	@Transactional
	public PlageHoraireLightDto updatePlageHoraire(PlageHoraireLightDto plageHoraireLightDto) {
		PlageHoraire plageToUpdate = modelmapper.map(plageHoraireLightDto, PlageHoraire.class);
		PlageHoraire updatePlage = plageRepository.updatePlageHoraire(plageToUpdate);
		PlageHoraireLightDto plagedto = modelmapper.map(updatePlage, PlageHoraireLightDto.class);
		return plagedto;
	}

	@Override
	@Transactional
	public Boolean deletePlageHoraireById(Long id) {
		return plageRepository.deletePlageHoraireById(id);
	}

	@Override
	@Transactional
	public PlageHoraireLightDto createPlageHoraire(PlageHoraireLightCreationDto plageHoraireLightCreationDto) {
		PlageHoraire plageToSave = modelmapper.map(plageHoraireLightCreationDto, PlageHoraire.class);
		PlageHoraire savedPlage = plageRepository.createPlageHoraire(plageToSave);
		PlageHoraireLightDto plageDto = modelmapper.map(savedPlage, PlageHoraireLightDto.class);
		return plageDto;
	}

}
