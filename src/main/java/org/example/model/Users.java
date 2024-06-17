package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUsuario;

    @Column
    private String nome;
    private String sobrenome;
    private String nomeUsuario;
    private int idade;
    private String cpf;
    private String email;
    private String senha;
}
