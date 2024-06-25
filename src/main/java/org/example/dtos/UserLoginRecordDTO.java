package org.example.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserLoginRecordDTO(@NotBlank String nomeUsuario, @NotBlank String senha) {
}
