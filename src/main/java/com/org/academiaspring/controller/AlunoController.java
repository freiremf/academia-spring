package com.org.academiaspring.controller;

import com.org.academiaspring.model.AlunoDto;
import com.org.academiaspring.model.AlunoFiltroDto;
import com.org.academiaspring.service.AlunoServico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<Page<AlunoDto>> buscarAlunos(@PageableDefault(direction = Sort.Direction.ASC) Pageable pageable) {
        return ok(alunoServico.buscarTodos(pageable));
    }

    @Override
    public ResponseEntity<Page<AlunoDto>> buscarAlunosPorFiltro(AlunoFiltroDto filtro, @PageableDefault(direction = Sort.Direction.ASC) Pageable pageable){
        return ok(alunoServico.buscarPorFiltro(filtro, pageable));
    }

    @Override
    public ResponseEntity<AlunoDto> buscarAlunoPorMatricula(String matricula) {
        return ok(alunoServico.buscarPorMatricula(matricula));
    }

    @Override
    public ResponseEntity<AlunoDto> salvarNovoAluno(AlunoDto alunoDto) {
        return ok(alunoServico.salvar(alunoDto));
    }

    @Override
    public ResponseEntity<Void> deletarAlunoPorMatricula(String matricula) {
        alunoServico.deletarPorMatricula(matricula);
        return ok().build();
    }
}
