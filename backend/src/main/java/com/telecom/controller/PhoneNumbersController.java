package com.telecom.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.telecom.model.PhoneNumbers;
import com.telecom.service.PhoneNumbersService;

@RestController
@RequestMapping("/phonenumber")
@CrossOrigin(origins = "http://localhost:4200")
public class PhoneNumbersController {

    @Autowired
    private PhoneNumbersService phoneNumbersService;

    @GetMapping("/all")
    public ResponseEntity<List<PhoneNumbers>> findAllPhoneNumbers() {
        List<PhoneNumbers> phoneNumbers = phoneNumbersService.findAllPhoneNumbers();
        return new ResponseEntity<>(phoneNumbers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PhoneNumbers> findPhoneNumberById(@PathVariable("id") Long id) {
        PhoneNumbers phoneNumbers = phoneNumbersService.findPhoneNumberById(id);
        return new ResponseEntity<>(phoneNumbers, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PhoneNumbers> addPhoneNumber(@RequestBody PhoneNumbers phoneNumbers) {
        PhoneNumbers newPhoneNumber = phoneNumbersService.addPhoneNumber(phoneNumbers);
        return new ResponseEntity<>(newPhoneNumber, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PhoneNumbers> updateDevice(@RequestBody PhoneNumbers phoneNumbers) {
        PhoneNumbers updatePhoneNumber = phoneNumbersService.addPhoneNumber(phoneNumbers);
        return new ResponseEntity<>(updatePhoneNumber, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePhoneNumberById(@PathVariable("id") Long id) {
        phoneNumbersService.deletePhoneNumbersById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

