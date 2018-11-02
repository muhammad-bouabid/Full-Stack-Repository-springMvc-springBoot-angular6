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

import com.backend.dto.light.PlageHoraireLightCreationDto;
import com.backend.dto.light.PlageHoraireLightDto;
import com.backend.dto.message.MessageDto;
import com.backend.dto.special.returned.PlageHoraireLightDtoRec;
import com.backend.service.PlageHoraireService;



/**
 * @author m.BOUABID
 *
 */
@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PlageHoraireController {
	
	
	@Autowired
	private PlageHoraireService plageService;
	
	@RequestMapping(value = "/plages", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllPlages() {
		List<PlageHoraireLightDtoRec> plages = plageService.getAllPlageHoraires();
		return ResponseEntity.status(HttpStatus.OK).body(plages);
	}
	
	
	@RequestMapping(value = "/plages/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getPlageById(@PathVariable Long id) {
		PlageHoraireLightDtoRec plage = plageService.getPlageHoraireByID(id);
		if(plage != null)
			return ResponseEntity.status(HttpStatus.OK).body(plage);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(plage);
	}
	
	@RequestMapping(value = "/plages/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> updatePlage(@RequestBody PlageHoraireLightDto plageHoraireLightDto) {
		PlageHoraireLightDto plage = plageService.updatePlageHoraire(plageHoraireLightDto);
		if(plage != null)
			return ResponseEntity.status(HttpStatus.OK).body(plage);
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
	}
	
	@RequestMapping(value = "/plages", method = RequestMethod.POST)
	public ResponseEntity<Object> createPlage(@RequestBody PlageHoraireLightCreationDto plageHoraireLightCreationDto) {
		PlageHoraireLightDto plage = plageService.createPlageHoraire(plageHoraireLightCreationDto);
		if(plage != null)
			return ResponseEntity.status(HttpStatus.OK).body(plage);
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
	}
	
	
	@RequestMapping(value = "/plages/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletePlage(@PathVariable Long id) {
		Boolean deleteStatus = plageService.deletePlageHoraireById(id);
		if(deleteStatus)
			return ResponseEntity.status(HttpStatus.OK).body(new MessageDto("DELETE IS DONE"));
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new MessageDto("DELETE IS DONE"));
	}

}