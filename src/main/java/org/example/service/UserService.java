package org.example.service;

import org.example.model.Users;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
