package org.example.service;

import org.example.dtos.UserLoginRecordDTO;
import org.example.model.Users;
import org.example.repository.UserRepository;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> saveUser(Users user) {
        if (userRepository.existsByNomeUsuario(user.getNomeUsuario())) {
            return ResponseEntity.status(400).body("Já existe um cadastro com este nome de usuário registrado.");
        }

        Users savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<?> getUserById(UUID id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(404).body("Não foram encontrados dados vinculados a este ID.");
    }

    public Users findByUsername(String nomeUsuario) {
        return userRepository.findByNomeUsuario(nomeUsuario)
                .orElse(null);
    }

    public ResponseEntity<String> removeById(UUID id) {
        Optional<Users> usuario = userRepository.findById(id);

        if (usuario.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("Usuário removido com sucesso.");
        } else {
            return ResponseEntity.status(404).body("Não foram encontrados dados vinculados a este ID.");
        }
    }

    public ResponseEntity<?> updateUser(UUID id, Map<String, Object> updates) {
        Users existingUser = userRepository.findById(id).orElse(null);

        if (existingUser != null) {
            BeanWrapper beanWrapper = new BeanWrapperImpl(existingUser);
            updates.forEach((key, value) -> {
                if (beanWrapper.isWritableProperty(key)) {
                    beanWrapper.setPropertyValue(key, value);
                }
            });
            userRepository.save(existingUser);
            return ResponseEntity.ok(existingUser);
        }

        return ResponseEntity.status(404).body("Usuário solicitado não encontrado.");
    }

    public ResponseEntity<String> loginUser(UserLoginRecordDTO login) {
        if (login.nomeUsuario() == null) {
            return ResponseEntity.status(401).body("Nome de usuário é obrigatório");
        }
        if (login.senha() == null) {
            return ResponseEntity.status(401).body("Senha é obrigatória");
        }

        Users foundUser = findByUsername(login.nomeUsuario());
        if (foundUser != null && foundUser.getSenha().equals(login.senha())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
