package org.example.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserRecordDTO(@NotBlank String nomeUsuario, @NotBlank String senha) {
}
