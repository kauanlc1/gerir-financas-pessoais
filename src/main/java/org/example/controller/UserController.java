package org.example.controller;

import jakarta.validation.Valid;
import org.example.dtos.UserLoginRecordDTO;
import org.example.model.Users;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/rescue")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> ransomedUsers = userService.getAllUsers();
        return ResponseEntity.ok(ransomedUsers);
    }

    @GetMapping("/rescue/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") UUID id) {
        return userService.getUserById(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(value = "id") UUID id,
                                            @RequestBody Map<String, Object> updates) {
        return userService.updateUser(id, updates);
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody Users user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginRecordDTO userLoginRecordDTO) {
        return userService.loginUser(userLoginRecordDTO);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") UUID id) {
        return userService.removeById(id);
    }
}
