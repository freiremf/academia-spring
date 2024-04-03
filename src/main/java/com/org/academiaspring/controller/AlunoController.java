package com.org.academiaspring.controller;

import com.org.academiaspring.model.AlunoDto;
import com.org.academiaspring.service.AlunoServico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/academia/alunos")
public class AlunoController implements AlunoApi {

    private final AlunoServico alunoServico;

    public AlunoController(AlunoServico alunoServico) {
        this.alunoServico = alunoServico;
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<AlunoDto>> buscarAlunos(Pageable pageable) {
        return ok(alunoServico.buscarTodos(pageable));
    }

    @Override
    @GetMapping("/{matricula}")
    public ResponseEntity<AlunoDto> buscarAlunoPorMatricula(String matricula) {
        return ok(alunoServico.buscarPorMatricula(matricula));
    }

    @Override
    @PostMapping
    public ResponseEntity<AlunoDto> salvarNovoAluno(AlunoDto alunoDto) {
        return ok(alunoServico.salvar(alunoDto));
    }

    @Override
    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deletarAlunoPorMatricula(String matricula) {
        alunoServico.deletarPorMatricula(matricula);
        return ok().build();
    }
}
