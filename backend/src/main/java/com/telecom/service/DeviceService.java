package com.telecom.service;

import java.util.List;

import com.telecom.model.Device;

public interface DeviceService {
    // define different functionalities/features for the devices to have
    Device create(Device device);

    List<Device> list(int limit);

    Device get(Long id);

    Device update(Device phonePlan);

    Boolean delete(Long id);
}
