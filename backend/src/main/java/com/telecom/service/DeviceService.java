package com.telecom.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telecom.model.Device;
import com.telecom.repository.DeviceRepository;

@Service
@Transactional
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    public List<Device> findAllDevices() {
        return deviceRepository.findAll();
    }

    public Device updateDevice(Device device) {
        return deviceRepository.save(device);
    }

    public void deleteDeviceById(Long id) {
        deviceRepository.deleteDeviceById(id);
    }

    public Device findDeviceById(Long id) {
        return deviceRepository.findDeviceById(id)
                .orElseThrow(() -> new PlanNotFoundException("Device with id" + id + " was not found"));
    }
}
