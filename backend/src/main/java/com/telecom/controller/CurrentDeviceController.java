package com.telecom.controller;

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
import com.telecom.model.CurrentDevice;
import com.telecom.service.CurrentDeviceService;
import java.util.*;

@RestController
@RequestMapping("/currentdevice")
@CrossOrigin(origins = "http://localhost:4200")
public class CurrentDeviceController {

    @Autowired
    private CurrentDeviceService currentDeviceService;

    @GetMapping("/all")
    public ResponseEntity<List<CurrentDevice>> findAllCurrentDevices() {
        List<CurrentDevice> currentDevices = currentDeviceService.findAllCurrentDevices();
        return new ResponseEntity<>(currentDevices, HttpStatus.OK);
    }

    // get user account phoneNumbers
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CurrentDevice>> findUserCurrentDevicesById(@PathVariable Long userId) {
        List<CurrentDevice> currentDevices = currentDeviceService.findUserCurrentDevicesById(userId);
        return new ResponseEntity<>(currentDevices, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CurrentDevice> findCurrentDeviceById(@PathVariable("id") Long id) {
        CurrentDevice currentDevice = currentDeviceService.findCurrentDeviceById(id);
        return new ResponseEntity<>(currentDevice, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CurrentDevice> addCurrentDevice(@RequestBody CurrentDevice currentDevice) {
        CurrentDevice newCurrentDevice = currentDeviceService.addCurrentDevice(currentDevice);
        return new ResponseEntity<>(newCurrentDevice, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CurrentDevice> updateCurrentDevice(@RequestBody CurrentDevice currentDevice) {
        CurrentDevice updateCurrentDevice = currentDeviceService.updateCurrentDevice(currentDevice);
        return new ResponseEntity<>(updateCurrentDevice, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCurrentDeviceById(@PathVariable("id") Long id) {
        currentDeviceService.deleteCurrentDeviceById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
