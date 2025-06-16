package com.practice.java.users.api.controller;

import com.practice.java.users.api.model.User;
import com.practice.java.users.api.respository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User API", description = "User CRUD maintenance API")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @Operation(summary = "Get all Users")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{email}")
    @Operation(summary = "Get user by email")
    public User getUserByEmail(@PathVariable String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }

    @PostMapping
    @Operation(summary = "Create new user")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existent user")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User userToUpdate) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(userToUpdate.getName());
                    user.setEmail(userToUpdate.getEmail());
                    user.setAge(userToUpdate.getAge());
                    user.setActive(userToUpdate.isActive());
                    User userUpdated = userRepository.save(user);
                    return ResponseEntity.ok(userUpdated);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes an user by id")
    public void deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
    }

}
