package com.telecom.service;

import java.util.List;

import com.telecom.model.User;

public interface UserService {
    // define different functionalities/features for the devices to have
    User create(User user);

    List<User> list(int limit);

    User get(Long id);

    User update(User user);

    Boolean delete(Long id);

    User findByEmail(String email);

}
