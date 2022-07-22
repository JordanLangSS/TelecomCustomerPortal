package com.telecom.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.telecom.model.PhoneNumbers;
import com.telecom.repository.PhoneNumbersRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j // log to see what is happening
@Service
@Transactional
public class PhoneNumbersService {


    @Autowired
	private static PhoneNumbersRepository PhoneNumbersRepository;

    
	public PhoneNumbers addPhoneNumber(PhoneNumbers phoneNumbers ) {
		log.info("Saving new phone number: {}", phoneNumbers.getPhoneNumber());
		return PhoneNumbersRepository.save(phoneNumbers);
	}

	public List<PhoneNumbers> findAllPhoneNumbers() {
		log.info("Getting all Phone Numbers");
		return PhoneNumbersRepository.findAll();
	}

	public PhoneNumbers updatePhoneNumbers(PhoneNumbers phoneNumbers) {
		log.info("Updating phone number: {}", phoneNumbers.getPhoneNumber());
		return  PhoneNumbersRepository.save(phoneNumbers);
	}

	public void deletePhoneNumbersById(Long id) {
		log.info("Deleting phone number Id: {}", id);
		PhoneNumbersRepository.deletePhoneNumberById(id);
	}

	public static PhoneNumbers findPhoneNumberById(Long id) {
		log.info("Getting Phone Number Id: {}", id);
		return PhoneNumbersRepository.findPhoneNumberById(id)
				.orElseThrow(() -> new PhoneNumberNotFoundException("Phone with id" + id + " was not found"));
	}
    
}
