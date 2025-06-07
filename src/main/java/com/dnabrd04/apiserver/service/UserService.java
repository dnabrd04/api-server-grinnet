package com.dnabrd04.apiserver.service;

import com.dnabrd04.apiserver.model.User;
import com.dnabrd04.apiserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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
     * Receives a firebase id gets the User with this id if exists.
     *
     * @param firebaseId to search on the database
     * @return the user with match the id on the database.
     */
    public Optional<User> getUserByFirebaseId(String firebaseId) {
        return userRepository.findByFirebaseId(firebaseId);
    }

    /**
     * Receives a username and gets the User with this username if exists.
     *
     * @param username to search on the database
     * @return the user with match the id on the database.
     */
    public List<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
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
     * Receives an user and update the user.
     *
     * @param user to update
     * @return the user's new values
     */
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Receives an idUser and a new token and update
     * the user with the new value for the token.
     *
     * @param firebaseId of user to update
     * @param token new value
     * @return the user's new values
     */
    public User updateToken(String firebaseId, String token) {
        User user = userRepository.findByFirebaseId(firebaseId).orElseThrow();
        user.setTokenPush(token);
        return userRepository.save(user);
    }

    /**
     * Receives a list withs ids and get the users that match with the id.
     *
     * @param ids is the list of users.
     * @return the list of users that match with the values.
     */
//    public List<User> findById_userIn(List<Long> ids) {
//        return userRepository.findById_userIn(ids);
//    }

    /**
     *
     */
    public boolean existsUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
