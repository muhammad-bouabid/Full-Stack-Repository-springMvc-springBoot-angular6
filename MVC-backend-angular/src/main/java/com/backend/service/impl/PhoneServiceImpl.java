package com.backend.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.dto.light.PhoneLightCreationDto;
import com.backend.dto.light.PhoneLightDto;
import com.backend.entities.Phone;
import com.backend.repository.PhoneRepository;
import com.backend.service.PhoneService;
import com.google.common.reflect.TypeToken;

@Service
@Transactional(readOnly = true)
public class PhoneServiceImpl implements PhoneService {

	
	@Autowired
	private PhoneRepository phoneRepository;
	
	
	@Autowired
	private ModelMapper modelmapper;
	
	
	
	@Override
	@SuppressWarnings("serial")
	public List<PhoneLightDto> getAllPhones() {
		List<Phone> phones = phoneRepository.getAllPhones();
		Type listType = new TypeToken<List<PhoneLightDto>>() {}.getType();
		List<PhoneLightDto> phonesdto = modelmapper.map(phones, listType);
		return phonesdto;
	}

	@Override
	public PhoneLightDto getPhoneByID(Long id) {
		PhoneLightDto phoneDto = null;
		Phone phone = phoneRepository.getPhoneByID(id);
		if(phone != null)
			phoneDto = modelmapper.map(phone, PhoneLightDto.class);
		return phoneDto;
	}

	@Override
	@Transactional
	public PhoneLightDto updatePhone(PhoneLightDto phone) {
		Phone toPhoneEntity = modelmapper.map(phone, Phone.class);
		Phone updatedPhone = phoneRepository.updatePhone(toPhoneEntity);
		PhoneLightDto phonedto = modelmapper.map(updatedPhone, PhoneLightDto.class);
		return phonedto;
	}

	@Override
	@Transactional
	public Boolean deletePhoneById(Long id) {
		return phoneRepository.deletePhoneById(id);
	}

	@Override
	@Transactional
	public PhoneLightDto createPhone(PhoneLightCreationDto phoneLightCreationDto) {
		Phone toPhoneEntity = modelmapper.map(phoneLightCreationDto, Phone.class);
		Phone savedPhone = phoneRepository.createPhone(toPhoneEntity);
		PhoneLightDto phonedto = modelmapper.map(savedPhone, PhoneLightDto.class);
		return phonedto;
	}

}
