package com.org.academiaspring.controller;

import com.org.academiaspring.model.AlunoDto;
import com.org.academiaspring.service.AlunoServico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/academia/alunos")
public class AlunoController {

    private final AlunoServico alunoServico;

    public AlunoController(AlunoServico alunoServico) {
        this.alunoServico = alunoServico;
    }

    @GetMapping
    public Page<AlunoDto> buscarAlunos(Pageable pageable) {
        return alunoServico.buscarTodos(pageable);
    }

    @GetMapping("/{matricula}")
    public AlunoDto buscarAlunoPorMatricula(String matricula) {
        return alunoServico.buscarPorMatricula(matricula);
    }

    @PostMapping
    public AlunoDto salvarNovoAluno(AlunoDto alunoDto) {
        return alunoServico.salvar(alunoDto);
    }

    @DeleteMapping("/{matricula}")
    public void deletarAlunoPorMatricula(String matricula) {
        alunoServico.deletarPorMatricula(matricula);
    }
}
