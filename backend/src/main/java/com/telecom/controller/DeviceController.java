package com.telecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.model.Device;
import com.telecom.model.Response;
import com.telecom.service.implementation.DeviceServiceImpl;

import java.util.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CREATED;
import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceServiceImpl deviceService;

    @GetMapping("/list")
    public ResponseEntity<Response> getDevices() {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(new HashMap<String, List<?>>() {
                            {
                                put("Devices", deviceService.list(30));
                            }
                        })
                        .message("Devices Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());

    }

    @PostMapping("/save")
    // Use valid to check if the new device is up to validation standards (from
    // model)
    public ResponseEntity<Response> saveDevices(@RequestBody @Valid Device device) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(new HashMap<String, Device>() {
                            {
                                put("Device", deviceService.create(device));
                            }
                        })
                        .message("Device Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDevice(@PathVariable("id") Long id) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(new HashMap<String, Device>() {
                            {
                                put("Device", deviceService.get(id));
                            }
                        })
                        .message("Device Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDevice(@PathVariable("id") Long id) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(new HashMap<String, Boolean>() {
                            {
                                put("Deleted", deviceService.delete(id));
                            }
                        })
                        .message("Device Deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

}
