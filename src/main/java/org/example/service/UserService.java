package org.example.service;

import org.example.model.Users;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users findByUsername(String nomeUsuario) {
        return userRepository.findByNomeUsuario(nomeUsuario)
                .orElse(null);
    }

    public Users findById(UUID id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    public void removeById(UUID id) {
        userRepository.deleteById(id);
    }
}
