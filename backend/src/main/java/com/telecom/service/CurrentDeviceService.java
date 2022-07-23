package com.telecom.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.model.CurrentDevice;
import com.telecom.repository.CurrentDeviceRepository;

@Service
@Transactional
public class CurrentDeviceService {
    @Autowired
    private CurrentDeviceRepository currentDeviceRepository;

    public CurrentDevice addCurrentDevice(CurrentDevice currentDevice) {
        return currentDeviceRepository.save(currentDevice);
    }

    public List<CurrentDevice> findAllCurrentDevices() {
        return currentDeviceRepository.findAll();
    }

    public CurrentDevice updateCurrentDevice(CurrentDevice currentDevice) {
        return currentDeviceRepository.save(currentDevice);
    }

    public void deleteCurrentDeviceById(Long id) {
        currentDeviceRepository.deleteCurrentDeviceById(id);
    }

    public CurrentDevice findCurrentDeviceById(Long id) {
        return currentDeviceRepository.findCurrentDeviceById(id)
                .orElseThrow(() -> new PlanNotFoundException("Device with id" + id + " was not found"));
    }
}
