package com.practice.java.users.api.controller;

import com.practice.java.users.api.dto.UserDto;
import com.practice.java.users.api.model.User;
import com.practice.java.users.api.respository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public User createUser(@RequestBody @Valid UserDto payload){
        User newUser = new User();
        newUser.setName(payload.getName());
        newUser.setEmail(payload.getEmail());
        newUser.setAge(payload.getAge());
        newUser.setActive(payload.isActive());
        return userRepository.save(newUser);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existent user")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody @Valid UserDto payload) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(payload.getName());
                    user.setEmail(payload.getEmail());
                    user.setAge(payload.getAge());
                    user.setActive(payload.isActive());
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
