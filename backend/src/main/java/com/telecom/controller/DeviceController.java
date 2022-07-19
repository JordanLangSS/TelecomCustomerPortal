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

import com.telecom.model.Device;
import com.telecom.service.DeviceService;

import java.util.*;

@RestController
@RequestMapping("/device")
@CrossOrigin(origins = "http://localhost:4200")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/all")
    public ResponseEntity<List<Device>> findAllDevices() {
        List<Device> devices = deviceService.findAllDevices();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Device> findDeviceById(@PathVariable("id") Long id) {
        Device device = deviceService.findDeviceById(id);
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        Device newDevice = deviceService.addDevice(device);
        return new ResponseEntity<>(newDevice, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Device> updateDevice(@RequestBody Device device) {
        Device updateDevice = deviceService.updateDevice(device);
        return new ResponseEntity<>(updateDevice, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDeviceById(@PathVariable("id") Long id) {
        deviceService.deleteDeviceById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
