package com.telecom.service.implementation;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.telecom.model.Device;
import com.telecom.repository.DeviceRepository;
import com.telecom.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import static java.lang.Boolean.TRUE;

@Service
@Transactional
@Slf4j // log to see what is happening
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Device create(Device device) {
        log.info("Saving new device: {}", device.getMake() + " " + device.getModel());
        return deviceRepository.save(device);
    }

    @Override
    public List<Device> list(int limit) {
        log.info("Getting all Devices");

        // Return a list (instead of a full page)to limit the amount per page
        // have to cast to a list because findAll would return a "page"
        return deviceRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Device get(Long id) {
        log.info("Getting device Id: {}", id);
        // You have to use .get to actually return the phonePlan it finds by that id
        return deviceRepository.findById(id).get();
    }

    @Override
    public Device update(Device device) {
        log.info("Updating device: {}", device.getMake() + " " + device.getModel());
        // ****if the Id does not exist, it will just create it!!!****
        return deviceRepository.save(device);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting device Id: {}", id);
        deviceRepository.deleteById(id);
        return TRUE;
    }

}
