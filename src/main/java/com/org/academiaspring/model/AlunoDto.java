package com.org.academiaspring.model;

import io.swagger.v3.oas.annotations.media.Schema;

public record AlunoDto(
        @Schema(description = "Matrícula do aluno", example = "202400880004", requiredMode = Schema.RequiredMode.REQUIRED)
        String matricula,
        @Schema(description = "Nome do aluno", example = "Matheus Freire", requiredMode = Schema.RequiredMode.REQUIRED)
        String nome,
        @Schema(description = "Telefone do aluno", example = "88888888")
        String telefone,
        @Schema(description = "Email do aluno", example = "mathmail@mail.com")
        String email,
        @Schema(description = "CPF do aluno", example = "00112345699", requiredMode = Schema.RequiredMode.REQUIRED)
        String cpf
) {
}
