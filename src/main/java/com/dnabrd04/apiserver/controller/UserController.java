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

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
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
