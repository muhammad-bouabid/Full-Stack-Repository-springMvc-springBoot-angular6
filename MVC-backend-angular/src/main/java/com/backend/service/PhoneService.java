/**
 * 
 */
package com.backend.service;

import java.util.List;


import com.backend.dto.light.PhoneLightCreationDto;
import com.backend.dto.light.PhoneLightDto;

/**
 * @author m.BOUABID
 *
 */
public interface PhoneService {
	
	/**
	 * get all Phones
	 * @return
	 */
	List<PhoneLightDto> getAllPhones();
	
	
	/**
	 * get phone by its id
	 * @param id
	 * @return
	 */
	PhoneLightDto getPhoneByID(Long id);
	
	
	/**
	 * update phone
	 * @param phone
	 * @return
	 */
	PhoneLightDto updatePhone(PhoneLightDto phone);
	
	
	/**
	 * Delete Phone by its ID
	 * @param id
	 */
	Boolean deletePhoneById(Long id);
	
	
	/**
	 * creation new phone
	 * @param phoneLightCreationDto
	 * @return
	 */
	PhoneLightDto createPhone(PhoneLightCreationDto phoneLightCreationDto);
}
