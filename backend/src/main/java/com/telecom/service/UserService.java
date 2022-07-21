package com.telecom.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.model.User;
import com.telecom.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }

    public User findUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName)
                .orElseThrow(() -> new PlanNotFoundException("user with username" + userName + " was not found"));
    }

    // public User findByEmail(String email) {
    // log.info("Getting user email: {}", email);
    // return userRepository.findByEmail(email);
    // }

}
