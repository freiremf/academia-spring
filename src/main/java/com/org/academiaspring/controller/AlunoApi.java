package com.org.academiaspring.controller;

import com.org.academiaspring.model.AlunoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Tag(name = "Aluno", description = "API de Alunos")
public interface AlunoApi {
    @Operation(summary = "Listar todos os alunos")
    @ApiResponse(responseCode = "200", description = "Alunos listados com sucesso")
    ResponseEntity<Page<AlunoDto>> buscarAlunos(Pageable pageable);

    @Operation(summary = "Buscar aluno por matrícula")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Aluno não encontrado")
    })
    ResponseEntity<AlunoDto> buscarAlunoPorMatricula(String matricula);

    @Operation(summary = "Salvar novo aluno")
    @ApiResponse(responseCode = "200", description = "Aluno salvo com sucesso")
    ResponseEntity<AlunoDto> salvarNovoAluno(AlunoDto alunoDto);

    @Operation(summary = "Deletar aluno por matrícula")
    @ApiResponse(responseCode = "200", description = "Aluno deletado com sucesso")
    ResponseEntity<Void> deletarAlunoPorMatricula(String matricula);
}
