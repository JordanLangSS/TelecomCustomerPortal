package com.telecom.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telecom.model.CurrentDevice;
import com.telecom.repository.CurrentDeviceRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j // log to see what is happening
@Service
@Transactional
public class CurrentDeviceService {
    @Autowired
    private CurrentDeviceRepository currentDeviceRepository;

    public CurrentDevice addCurrentDevice(CurrentDevice currentDevice) {
        log.info("Saving new device: {}", currentDevice.getMake() + " " + currentDevice.getModel());
        return currentDeviceRepository.save(currentDevice);
    }

    public List<CurrentDevice> findAllCurrentDevices() {
        log.info("Getting all current devices");
        return currentDeviceRepository.findAll();
    }

    public CurrentDevice updateCurrentDevice(CurrentDevice currentDevice) {
        log.info("Updating current device: {}", currentDevice.getMake() + " " + currentDevice.getModel());
        return currentDeviceRepository.save(currentDevice);
    }

    public void deleteCurrentDeviceById(Long id) {
        log.info("Deleting current device Id: {}", id);
        currentDeviceRepository.deleteCurrentDeviceById(id);
    }

    public CurrentDevice findCurrentDeviceById(Long id) {
        log.info("Getting current device Id: {}", id);
        return currentDeviceRepository.findCurrentDeviceById(id)
                .orElseThrow(() -> new PlanNotFoundException("Device with id" + id + " was not found"));
    }

    public List<CurrentDevice> findUserCurrentDevicesById(Long id) {
        log.info("Getting current devices for user Id: {}", id);
        return currentDeviceRepository.findUserCurrentDevicesById(id);
    }
}
