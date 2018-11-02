/**
 * 
 */
package com.backend.repository;

import java.util.List;

import com.backend.entities.PlageHoraire;

/**
 * @author m.BOUABID
 *
 */
public interface PlageHoraireRepository {
	
	/**
	 * get all PlageHoraires
	 * 
	 * @return
	 */
	List<PlageHoraire> getAllPlageHoraires();

	/**
	 * get PlageHoraire by its id
	 * 
	 * @param id
	 * @return
	 */
	PlageHoraire getPlageHoraireByID(Long id);

	/**
	 * update PlageHoraire
	 * 
	 * @param PlageHoraire
	 * @return
	 */
	PlageHoraire updatePlageHoraire(PlageHoraire plageHoraire);

	/**
	 * Delete PlageHoraire by its ID
	 * 
	 * @param id
	 */
	Boolean deletePlageHoraireById(Long id);

	/**
	 * creation new PlageHoraire
	 * 
	 * @param plageHoraire
	 * @return
	 */
	PlageHoraire createPlageHoraire(PlageHoraire plageHoraire);
}
