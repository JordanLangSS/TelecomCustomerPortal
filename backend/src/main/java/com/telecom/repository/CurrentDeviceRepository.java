package com.telecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.model.CurrentDevice;

// class name and primary key type
@Repository
public interface CurrentDeviceRepository extends JpaRepository<CurrentDevice, Long> {

    void deleteCurrentDeviceById(Long id);

    Optional<CurrentDevice> findCurrentDeviceById(Long id);

}
