package com.org.academiaspring.service;

import com.org.academiaspring.config.ResourceNotFoundException;
import com.org.academiaspring.model.AlunoConverter;
import com.org.academiaspring.model.AlunoDto;
import com.org.academiaspring.repository.AlunoRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlunoServico {
    private final AlunoRepositorio alunoRepositorio;

    public AlunoServico(AlunoRepositorio alunoRepositorio) {
        this.alunoRepositorio = alunoRepositorio;
    }

    public Page<AlunoDto> buscarTodos(Pageable pageable) {
        return new PageImpl<>(alunoRepositorio.findAll(pageable)
                .stream()
                .map(AlunoConverter::toAlunoDto)
                .toList());
    }

    public AlunoDto salvar(AlunoDto alunoDto) {
        return AlunoConverter.toAlunoDto(alunoRepositorio.save(AlunoConverter.toAluno(alunoDto)));
    }

    public AlunoDto buscarPorMatricula(String matricula) {
        return AlunoConverter.toAlunoDto(alunoRepositorio.findByMatricula(matricula).orElseThrow(
                () -> new ResourceNotFoundException("Aluno não encontrado")));
    }

    public void deletarPorMatricula(String matricula) {
        alunoRepositorio.deleteByMatricula(matricula);
    }
}
