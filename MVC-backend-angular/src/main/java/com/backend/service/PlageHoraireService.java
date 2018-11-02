/**
 * 
 */
package com.backend.service;

import java.util.List;

import com.backend.dto.light.PlageHoraireLightCreationDto;
import com.backend.dto.light.PlageHoraireLightDto;
import com.backend.dto.special.returned.PlageHoraireLightDtoRec;

/**
 * @author m.BOUABID
 *
 */
public interface PlageHoraireService {
	/**
	 * get all PlageHoraires
	 * 
	 * @return
	 */
	List<PlageHoraireLightDtoRec> getAllPlageHoraires();

	/**
	 * get PlageHoraire by its id
	 * 
	 * @param id
	 * @return
	 */
	PlageHoraireLightDtoRec getPlageHoraireByID(Long id);

	/**
	 * update PlageHoraire
	 * 
	 * @param PlageHoraire
	 * @return
	 */
	PlageHoraireLightDto updatePlageHoraire(PlageHoraireLightDto plageHoraireLightDto);

	/**
	 * Delete PlageHoraire by its ID
	 * 
	 * @param id
	 */
	Boolean deletePlageHoraireById(Long id);

	/**
	 * creation new PlageHoraire
	 * 
	 * @param plageHoraireLightCreationDto
	 * @return
	 */
	PlageHoraireLightDto createPlageHoraire(PlageHoraireLightCreationDto plageHoraireLightCreationDto);
}
