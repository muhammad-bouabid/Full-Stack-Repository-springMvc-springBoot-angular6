/**
 * 
 */
package com.backend.service;

import java.util.List;

import com.backend.dto.light.FileLightCreationDto;
import com.backend.dto.light.FileLightDto;

/**
 * @author m.BOUABID
 *
 */
public interface FileService {
	/**
	 * get all Files
	 * @return
	 */
	List<FileLightDto> getAllFiles();
	
	
	/**
	 * get file by its id
	 * @param id
	 * @return
	 */
	FileLightDto getFileByID(Long id);
	
	
	/**
	 * update file
	 * @param file
	 * @return
	 */
	FileLightDto updateFile(FileLightDto file);
	
	
	/**
	 * Delete File by its ID
	 * @param id
	 */
	Boolean deleteFileById(Long id);
	
	
	/**
	 * creation new file
	 * @param fileLightCreationDto
	 * @return
	 */
	FileLightDto createFile(FileLightCreationDto fileLightCreationDto);
}
