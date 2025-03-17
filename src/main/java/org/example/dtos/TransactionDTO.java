package org.example.dtos;

import java.util.Date;

public record TransactionDTO(Long id, String descricao, Double amount, Date dataTransacao, String nomeUsuario, String descricaoCategoria) {
}
