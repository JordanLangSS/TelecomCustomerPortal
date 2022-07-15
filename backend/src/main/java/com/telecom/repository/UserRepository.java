package com.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.model.User;

// class name and primary key type
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // tell JPA to use a select with "findBY"
    User findByEmail(String email);

}