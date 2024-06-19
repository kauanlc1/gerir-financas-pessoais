package org.example.controller;

import org.example.model.Users;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        Users savedUsers = userService.saveUser(user);
        return ResponseEntity.ok(savedUsers);
    }
    @GetMapping("/rescue")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> ransomedUsers = userService.getAllUsers();
        return ResponseEntity.ok(ransomedUsers);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user) {
        Users foundUser = userService.findByUsername(user.getNomeUsuario());
        if (foundUser != null && foundUser.getSenha().equals(user.getSenha())) {
            return ResponseEntity.ok("Login successful");
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

    @GetMapping("rescue/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") UUID id) {
        Users usuario = userService.findById(id);

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(401).body("Não foram encotrados dados vinculados a este ID.");
        }
    }
}
