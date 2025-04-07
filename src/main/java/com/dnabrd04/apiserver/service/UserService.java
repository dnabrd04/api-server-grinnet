package com.dnabrd04.apiserver.service;

import com.dnabrd04.apiserver.model.User;
import com.dnabrd04.apiserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class will be used to do all the database operations of the User class.
 *
 * @author dnabrd04
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Receives a user and adds it to the database.
     *
     * @param user to add on the database
     * @return the user added on the database.
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Receives an id gets the User with this id.
     *
     * @param id to search on the database
     * @return the user with match the id on the database.
     */
    public User getUser(Long id) {
        return userRepository.getReferenceById(id);
    }

    /**
     * Gets all the Users
     *
     * @return the user with match the id on the database.
     */
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * Receives an id and delete the user with this id.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Receives an id and delete the user with this id.
     *
     * @param user to update
     * @return the user's new values
     */
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
