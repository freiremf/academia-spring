package com.org.academiaspring.repository;

import com.org.academiaspring.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepositorio extends JpaRepository<Aluno, Long>, JpaSpecificationExecutor<Aluno> {
    Optional<Aluno> findByMatricula(String matricula);
    Optional<Aluno> findByCpf(String cpf);
    Optional<Aluno> findByEmail(String email);
    void deleteByMatricula(String matricula);
}
