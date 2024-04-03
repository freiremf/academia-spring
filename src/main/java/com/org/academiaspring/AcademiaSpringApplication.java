package com.org.academiaspring;

import com.org.academiaspring.model.Aluno;
import com.org.academiaspring.repository.AlunoRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AcademiaSpringApplication {

    public static void main(String[] args) {SpringApplication.run(AcademiaSpringApplication.class, args);}

    @Bean
    CommandLineRunner initDatabase(AlunoRepositorio repository) {
        return args -> {
            repository.deleteAll();

            Aluno aluno1 = new Aluno();
            aluno1.setMatricula("202400880001");
            aluno1.setNome("Kleber Bambam");
            aluno1.setTelefone("123456789");
            aluno1.setEmail("kleber_bambam@mail.com");
            aluno1.setCpf("12345678900");
            repository.save(aluno1);

            Aluno aluno2 = new Aluno();
            aluno2.setMatricula("202400880002");
            aluno2.setNome("Léo Stronda");
            aluno2.setTelefone("987654321");
            aluno2.setEmail("leo_stronda@mail.com");
            aluno2.setCpf("98765432100");
            repository.save(aluno2);

            Aluno aluno3 = new Aluno();
            aluno3.setMatricula("202400880003");
            aluno3.setNome("Arnold Schwarzenegger");
            aluno3.setTelefone("432198765");
            aluno3.setEmail("arnold_schwarzenegger@mail.com");
            aluno3.setCpf("43219876500");
            repository.save(aluno3);
        };
    }
}
