package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import com.backend.dto.light.PhoneLightDto;
import com.backend.dto.message.MessageDto;
import com.backend.service.PhoneService;



/**
 * @author m.BOUABID
 *
 */
@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PhoneController {

	@Autowired
	private PhoneService phoneService;
	
	
	@RequestMapping(value = "/phones", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllPhones() {
		System.out.println("session Id =========> " + RequestContextHolder.currentRequestAttributes().getSessionId()); // to delete
		List<PhoneLightDto> phones = phoneService.getAllPhones();
		return ResponseEntity.status(HttpStatus.OK).body(phones);
	}
	
	
	@RequestMapping(value = "/phones/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getPhoneById(@PathVariable Long id) {
		PhoneLightDto phone = phoneService.getPhoneByID(id);
		if(phone != null)
			return ResponseEntity.status(HttpStatus.OK).body(phone);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(phone);
	}
	
	@RequestMapping(value = "/phones/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> updatePhone(@RequestBody PhoneLightDto Phonelightdto) {
		PhoneLightDto phone = phoneService.updatePhone(Phonelightdto);
		if(phone != null)
			return ResponseEntity.status(HttpStatus.OK).body(phone);
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
	}
	
	@RequestMapping(value = "/phones", method = RequestMethod.POST)
	public ResponseEntity<Object> createPhone(@RequestBody PhoneLightDto Phonelightdto) {
		PhoneLightDto phone = phoneService.createPhone(Phonelightdto);
		if(phone != null)
			return ResponseEntity.status(HttpStatus.OK).body(phone);
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
	}
	
	
	@RequestMapping(value = "/phones/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletePhone(@PathVariable Long id) {
		Boolean deleteStatus = phoneService.deletePhoneById(id);
		if(deleteStatus)
			return ResponseEntity.status(HttpStatus.OK).body(new MessageDto("DELETE IS DONE"));
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new MessageDto("DELETE IS FAILED"));
	}
}