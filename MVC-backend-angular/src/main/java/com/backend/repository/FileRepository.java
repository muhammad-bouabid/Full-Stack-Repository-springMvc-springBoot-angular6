/**
 * 
 */
package com.backend.repository;

import java.util.List;

import com.backend.entities.File;

/**
 * @author m.BOUABID
 *
 */
public interface FileRepository {

	/**
	 * get all Files
	 * @return
	 */
	List<File> getAllFiles();
	
	
	/**
	 * get file by its id
	 * @param id
	 * @return
	 */
	File getFileByID(Long id);
	
	
	/**
	 * update file
	 * @param file
	 * @return
	 */
	File updateFile(File file);
	
	
	/**
	 * Delete File by its ID
	 * @param id
	 */
	Boolean deleteFileById(Long id);
	
	
	/**
	 * creation new file
	 * @param file
	 * @return
	 */
	File createFile(File file);
}
