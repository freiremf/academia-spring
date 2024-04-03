package com.org.academiaspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String matricula;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(length = 13)
    private String telefone;

    @Column
    private String email;

    @Column (length = 11, nullable = false)
    private String cpf;
}
