/**
 * 
 */
package com.backend.repository;

import java.util.List;

import com.backend.entities.Phone;

/**
 * @author m.BOUABID
 *
 */
public interface PhoneRepository {
	
	/**
	 * get all Phones
	 * @return
	 */
	List<Phone> getAllPhones();
	
	
	/**
	 * get phone by its id
	 * @param id
	 * @return
	 */
	Phone getPhoneByID(Long id);
	
	
	/**
	 * update phone
	 * @param phone
	 * @return
	 */
	Phone updatePhone(Phone phone);
	
	
	/**
	 * Delete Phone by its ID
	 * @param id
	 */
	Boolean deletePhoneById(Long id);
	
	
	/**
	 * creation new phone
	 * @param phone
	 * @return
	 */
	Phone createPhone(Phone phone);
}
