package com.telecom.service.implementation;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.telecom.model.User;
import com.telecom.repository.UserRepository;
import com.telecom.service.UserService;
import lombok.extern.slf4j.Slf4j;
import static java.lang.Boolean.TRUE;

@Service
@Transactional
@Slf4j // log to see what is happening
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        log.info("Saving new user: {}", user.getFirstName() + " " + user.getLastName());
        return userRepository.save(user);
    }

    @Override
    public List<User> list(int limit) {
        log.info("Getting all users");

        // Return a list (instead of a full page)to limit the amount per page
        // have to cast to a list because findAll would return a "page"
        return userRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public User get(Long id) {
        log.info("Getting user Id: {}", id);
        // You have to use .get to actually return the phonePlan it finds by that id
        return userRepository.findById(id).get();
    }

    @Override
    public User update(User user) {
        log.info("Updating user: {}", user.getFirstName() + " " + user.getLastName());
        // ****if the Id does not exist, it will just create it!!!****
        return userRepository.save(user);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting user Id: {}", id);
        userRepository.deleteById(id);
        return TRUE;
    }

    @Override
    public User findByEmail(String email) {
        log.info("Getting user email: {}", email);
        return userRepository.findByEmail(email);
    }

}
