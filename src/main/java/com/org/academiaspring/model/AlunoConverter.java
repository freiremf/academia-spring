package com.org.academiaspring.model;

public class AlunoConverter {
    private AlunoConverter(){
    }

    public static AlunoDto toAlunoDto(Aluno aluno) {
        return new AlunoDto(aluno.getMatricula(), aluno.getNome(), aluno.getTelefone(), aluno.getEmail());
    }

    public static Aluno toAluno(AlunoDto alunoDto) {
        Aluno aluno = new Aluno();
        aluno.setMatricula(alunoDto.matricula());
        aluno.setNome(alunoDto.nome());
        aluno.setTelefone(alunoDto.telefone());
        aluno.setEmail(alunoDto.email());
        return aluno;
    }
}
