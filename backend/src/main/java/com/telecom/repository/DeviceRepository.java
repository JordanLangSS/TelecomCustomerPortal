package com.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.model.Device;

// class name and primary key type
@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

}
