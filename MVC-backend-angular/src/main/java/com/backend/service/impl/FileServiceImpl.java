package com.backend.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.backend.dto.light.FileLightCreationDto;
import com.backend.dto.light.FileLightDto;
import com.backend.entities.File;
import com.backend.repository.FileRepository;
import com.backend.service.FileService;
import com.google.common.reflect.TypeToken;

@Service(value="fileservice")
@Transactional(readOnly = true)
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileRepository fileRepository;

	@Autowired
	private ModelMapper modelmapper;
	
	public FileRepository getFileRepository() {
		return fileRepository;
	}

	public void setFileRepository(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}

	@Override
	@SuppressWarnings("serial")
	public List<FileLightDto> getAllFiles() {
		List<File> files = fileRepository.getAllFiles();
		Type listType = new TypeToken<List<FileLightDto>>() {}.getType();
		List<FileLightDto> filesDto = modelmapper.map(files, listType);
		return filesDto;
	}

	@Override
	public FileLightDto getFileByID(Long id) {
		File file = fileRepository.getFileByID(id);
		FileLightDto filedto = null;
		if(file != null)
			filedto = modelmapper.map(file, FileLightDto.class);
		return filedto;
	}

	@Override
	@Transactional
	public FileLightDto updateFile(FileLightDto file) {
		File fileEn = modelmapper.map(file, File.class);
		fileEn = fileRepository.updateFile(fileEn);
		FileLightDto filedto = modelmapper.map(fileEn, FileLightDto.class);
		return filedto;
	}

	@Override
	@Transactional
	public Boolean deleteFileById(Long id) {
		return fileRepository.deleteFileById(id);
	}

	@Override
	@Transactional
	public FileLightDto createFile(FileLightCreationDto fileLightCreationDto) {
		TransactionStatus statu = TransactionAspectSupport.currentTransactionStatus(); // Test Transaction Opend or Closed
		System.out.println(statu);
		File fileEn = modelmapper.map(fileLightCreationDto, File.class);
		File savedfile = fileRepository.createFile(fileEn);
		FileLightDto filedto = modelmapper.map(savedfile, FileLightDto.class);
		return filedto;
	}
}
