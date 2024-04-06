package com.org.academiaspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoFiltroDto {
    private String matricula;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
}
