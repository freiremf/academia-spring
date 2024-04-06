package com.org.academiaspring.controller;

import com.org.academiaspring.model.AlunoDto;
import com.org.academiaspring.model.AlunoFiltroDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Tag(name = "Aluno", description = "API de Alunos")
public interface AlunoApi {
    @Operation(summary = "Listar todos os alunos")
    @GetMapping
    @ApiResponse(responseCode = "200", description = "Alunos listados com sucesso")
    ResponseEntity<Page<AlunoDto>> buscarAlunos(Pageable pageable);

    @Operation(summary = "Buscar alunos por filtro")
    @GetMapping("/filtro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alunos listados com sucesso", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = AlunoDto.class))}),
            @ApiResponse(responseCode = "400", description = "Aluno não encontrado")
    })
    ResponseEntity<Page<AlunoDto>> buscarAlunosPorFiltro(AlunoFiltroDto filtro, Pageable pageable);

    @Operation(summary = "Buscar aluno por matrícula")
    @GetMapping("/{matricula}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Aluno não encontrado")
    })
    ResponseEntity<AlunoDto> buscarAlunoPorMatricula(String matricula);

    @Operation(summary = "Salvar novo aluno")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno salvo com sucesso"),
            @ApiResponse(responseCode = "400", description = "Matrícula já cadastrada para outro aluno"),
            @ApiResponse(responseCode = "400", description = "CPF já cadastrado para outro aluno"),
            @ApiResponse(responseCode = "400", description = "Email já cadastrado para outro aluno"),
    })
    ResponseEntity<AlunoDto> salvarNovoAluno(AlunoDto alunoDto);

    @Operation(summary = "Deletar aluno por matrícula")
    @DeleteMapping("/{matricula}")
    @ApiResponse(responseCode = "200", description = "Aluno deletado com sucesso")
    ResponseEntity<Void> deletarAlunoPorMatricula(String matricula);
}
