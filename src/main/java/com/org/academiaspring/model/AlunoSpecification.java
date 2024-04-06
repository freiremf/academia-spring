package com.org.academiaspring.model;

import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class AlunoSpecification {

    private AlunoSpecification(){}

    public static Specification<Aluno> buscarPorMatricula(AlunoFiltroDto filtro) {
        return (root, query, criteriaBuilder) -> {
            if(Objects.nonNull(filtro.getMatricula()))
                return criteriaBuilder.equal(root.get("matricula"), filtro.getMatricula());
            return criteriaBuilder.conjunction();
        };
    }

    public static Specification<Aluno> buscarPorNome(AlunoFiltroDto filtro) {
        return (root, query, criteriaBuilder) -> {
            if(Objects.nonNull(filtro.getNome()))
                return criteriaBuilder.like(root.get("nome"), "%" + filtro.getNome() + "%");
            return criteriaBuilder.conjunction();
        };
    }

    public static Specification<Aluno> buscarPorTelefone(AlunoFiltroDto filtro) {
        return (root, query, criteriaBuilder) -> {
            if(Objects.nonNull(filtro.getTelefone()))
                return criteriaBuilder.equal(root.get("telefone"), filtro.getTelefone());
            return criteriaBuilder.conjunction();
        };
    }

    public static Specification<Aluno> buscarPorEmail(AlunoFiltroDto filtro) {
        return (root, query, criteriaBuilder) -> {
            if(Objects.nonNull(filtro.getEmail()))
                return criteriaBuilder.equal(root.get("email"), filtro.getEmail());
            return criteriaBuilder.conjunction();
        };
    }

    public static Specification<Aluno> buscarPorCpf(AlunoFiltroDto filtro) {
        return (root, query, criteriaBuilder) -> {
            if(Objects.nonNull(filtro.getCpf()))
                return criteriaBuilder.equal(root.get("cpf"), filtro.getCpf());
            return criteriaBuilder.conjunction();
        };
    }
}
