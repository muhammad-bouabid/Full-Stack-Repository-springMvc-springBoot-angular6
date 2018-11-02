package com.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import com.backend.dto.light.FileLightDto;
import com.backend.dto.message.MessageDto;
import com.backend.entities.User;
import com.backend.service.FileService;



/**
 * @author m.BOUABID
 *
 */
@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class FileController {

	@Autowired
	private FileService fileservice;

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/files", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllFiles() {
		System.out.println("session Id =========> " + RequestContextHolder.currentRequestAttributes().getSessionId()); // to delete
		List<FileLightDto> files = fileservice.getAllFiles();
		return ResponseEntity.status(HttpStatus.OK).body(files);
	}
	
	
	@RequestMapping(value = "/files/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getFileById(@PathVariable Long id) {
		FileLightDto file = fileservice.getFileByID(id);
		if(file != null)
			return ResponseEntity.status(HttpStatus.OK).body(file);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(file);
	}
	
	@RequestMapping(value = "/files/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateFile(@RequestBody FileLightDto filelightdto) {
		FileLightDto file = fileservice.updateFile(filelightdto);
		if(file != null)
			return ResponseEntity.status(HttpStatus.OK).body(file);
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
	}
	
	@RequestMapping(value = "/files", method = RequestMethod.POST)
	public ResponseEntity<Object> createFile(@RequestBody FileLightDto filelightdto) {
		FileLightDto file = fileservice.createFile(filelightdto);
		if(file != null)
			return ResponseEntity.status(HttpStatus.OK).body(file);
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
	}
	
	
	@RequestMapping(value = "/files/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteFile(@PathVariable Long id) {
		Boolean deleteStatus = fileservice.deleteFileById(id);
		if(deleteStatus)
			return ResponseEntity.status(HttpStatus.OK).body(new MessageDto("DELETE IS DONE"));
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new MessageDto("DELETE IS FAILED"));
	}
}