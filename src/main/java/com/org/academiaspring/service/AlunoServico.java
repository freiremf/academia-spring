package com.org.academiaspring.service;

import com.org.academiaspring.config.BadRequestException;
import com.org.academiaspring.config.ResourceNotFoundException;
import com.org.academiaspring.model.*;
import com.org.academiaspring.repository.AlunoRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    public Page<AlunoDto> buscarPorFiltro(AlunoFiltroDto filtro, Pageable page){
        Specification<Aluno> specification =
            Specification.where(AlunoSpecification.buscarPorMatricula(filtro))
                .and(AlunoSpecification.buscarPorNome(filtro))
                .and(AlunoSpecification.buscarPorTelefone(filtro))
                .and(AlunoSpecification.buscarPorEmail(filtro))
                .and(AlunoSpecification.buscarPorCpf(filtro));
        return Optional.of(alunoRepositorio.findAll(specification, page))
                .map(alunos -> new PageImpl<>(alunos.stream()
                        .map(AlunoConverter::toAlunoDto)
                        .toList()))
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum aluno encontrado"));
    }

    @Transactional
    public AlunoDto salvar(AlunoDto dto) {
        validarInformacoesParaSalvar(dto);
        return AlunoConverter.toAlunoDto(alunoRepositorio.save(AlunoConverter.toAluno(dto)));
    }

    public AlunoDto buscarPorMatricula(String matricula) {
        return AlunoConverter.toAlunoDto(alunoRepositorio.findByMatricula(matricula).orElseThrow(
                () -> new ResourceNotFoundException("Aluno não encontrado")));
    }

    @Transactional
    public void deletarPorMatricula(String matricula) {
        alunoRepositorio.deleteByMatricula(matricula);
    }

    private void validarInformacoesParaSalvar(AlunoDto dto){
        if(alunoRepositorio.findByMatricula(dto.matricula()).isPresent()){
            throw new BadRequestException("Matrícula já cadastrada para outro aluno");
        }
        if(alunoRepositorio.findByCpf(dto.cpf()).isPresent()){
            throw new BadRequestException("CPF já cadastrado para outro aluno");
        }
        if(alunoRepositorio.findByEmail(dto.email()).isPresent()){
            throw new BadRequestException("Email já cadastrado para outro aluno");
        }
    }
}
