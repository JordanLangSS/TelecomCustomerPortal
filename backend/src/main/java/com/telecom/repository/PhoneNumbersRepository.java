package com.telecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.model.PhoneNumbers;

@Repository
public interface PhoneNumbersRepository extends JpaRepository {
    
    void deletePhoneNumberById(Long id);

    Optional<PhoneNumbers> findPhoneNumberById(Long id);


}
