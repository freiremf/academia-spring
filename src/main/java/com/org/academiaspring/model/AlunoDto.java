package com.org.academiaspring.model;

public record AlunoDto(
        String matricula,
        String nome,
        String telefone,
        String email
) {
}
