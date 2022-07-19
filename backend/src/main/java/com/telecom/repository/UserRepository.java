package com.telecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.model.User;

// class name and primary key type
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    void deleteUserById(Long id);

    Optional<User> findUserByUserName(String userName);

}

// tell JPA to use a select with "findBY"
// User findByEmail(String email);