package com.telecom.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.model.PhoneNumbers;

@Repository
@Transactional
public interface PhoneNumbersRepository extends JpaRepository<PhoneNumbers, Long> {
    
    void deletePhoneNumberById(Long id);

    Optional<PhoneNumbers> findPhoneNumberById(Long id);


}
