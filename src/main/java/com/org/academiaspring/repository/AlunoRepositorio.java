package com.org.academiaspring.repository;

import com.org.academiaspring.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepositorio extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByMatricula(String matricula);
    void deleteByMatricula(String matricula);
}
