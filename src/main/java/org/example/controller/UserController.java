package org.example.controller;

import jakarta.validation.Valid;
import org.example.dtos.UserRecordDTO;
import org.example.model.Users;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        Users usuario = userService.findById(id);

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(401).body("Não foram encotrados dados vinculados a este ID.");
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable(value = "id") UUID id, @RequestBody Map<String, Object> updates) {
        Users updatedUser = userService.updateUser(id, updates);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        Users savedUsers = userService.saveUser(user);
        return ResponseEntity.ok(savedUsers);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserRecordDTO userRecordDTO) {
        Users foundUser = userService.findByUsername(userRecordDTO.nomeUsuario());
        String foundPw = userRecordDTO.senha();
        String foundUserName = userRecordDTO.nomeUsuario();

        if (foundUser != null && foundUser.getSenha().equals(userRecordDTO.senha())) {
            return ResponseEntity.ok("Login successful");
        } else if (foundPw == null) {
            return ResponseEntity.status(401).body("Senha é obrigatória");
        } else if (foundUserName == null) {
            return ResponseEntity.status(401).body("Nome de usuário é obrigatório");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") UUID id) {
        Users usuario = userService.findById(id);

        if (usuario != null) {
            userService.removeById(id);
            return ResponseEntity.ok("Usuário removido com sucesso.");
        } else {
            return ResponseEntity.status(401).body("Não foram encotrados dados vinculados a este ID.");
        }
    }
}
