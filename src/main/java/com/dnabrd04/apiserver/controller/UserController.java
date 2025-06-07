package com.dnabrd04.apiserver.controller;

import com.dnabrd04.apiserver.model.User;
import com.dnabrd04.apiserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> listUsers() {
        return userService.getUsers();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Boolean> existsUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.existsUsername(username));
    }

    @PutMapping("/token/{firebaseId}")
    public ResponseEntity<User> updateToken(@PathVariable String firebaseId, @RequestBody String token) {
        return ResponseEntity.ok(userService.updateToken(firebaseId, token));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

//    @PostMapping("/search")
//    public ResponseEntity<List<User>> getUser(@RequestBody List<Long> ids) {
//        return ResponseEntity.ok(userService.findById_userIn(ids));
//    }


    @GetMapping("/firebase/{firebaseId}")
    public ResponseEntity<User> getUserByFirebaseId(@PathVariable String firebaseId) {
        return userService.getUserByFirebaseId(firebaseId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search/{username}")
    public ResponseEntity<List<User>> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("image/{id}")
    public ResponseEntity<User> updateUserImage(@PathVariable Long id, @RequestBody String userImage) {
        User existingUser = userService.getUser(id);

        if( existingUser == null ) {
            return ResponseEntity.noContent().build();
        }

        existingUser.setImage(userImage);

        return ResponseEntity.ok(userService.updateUser(existingUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userService.getUser(id);

        if( existingUser == null ) {
            return ResponseEntity.noContent().build();
        }

        existingUser.setDescription(user.getDescription());
        existingUser.setImage(user.getImage());
        existingUser.setPrivacity(user.getPrivacity());

        return ResponseEntity.ok(userService.updateUser(existingUser));
    }
}
