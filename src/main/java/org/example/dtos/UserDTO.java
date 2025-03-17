package org.example.dtos;

import java.util.UUID;

public record UserDTO(UUID id, String nome, String sobrenome, String nomeUsuario, String email) {
}
