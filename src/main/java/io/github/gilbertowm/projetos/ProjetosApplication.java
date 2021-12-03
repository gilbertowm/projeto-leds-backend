package io.github.gilbertowm.projetos;

import io.github.gilbertowm.projetos.model.entity.Membro;
import io.github.gilbertowm.projetos.model.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjetosApplication {

    /*@Bean
    public CommandLineRunner run(@Autowired MembroRepository repository){
        return args -> {
            Membro membro = Membro.builder().cpf("00000000000").nome("Fulano").email("fulano@fulano.br").build();
            repository.save(membro);
        };
    }*/
    public static void main(String[] args) {
        SpringApplication.run(ProjetosApplication.class,args);
    }
}
