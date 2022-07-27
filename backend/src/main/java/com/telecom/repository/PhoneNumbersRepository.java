package com.telecom.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telecom.model.PhoneNumbers;

@Repository
@Transactional
public interface PhoneNumbersRepository extends JpaRepository<PhoneNumbers, Long> {

    void deletePhoneNumberById(Long id);

    Optional<PhoneNumbers> findPhoneNumberById(Long id);

    @Query(value = "select * from phone_numbers where user_id = :id", nativeQuery = true)
    List<PhoneNumbers> findUserPhoneNumById(Long id);

}
