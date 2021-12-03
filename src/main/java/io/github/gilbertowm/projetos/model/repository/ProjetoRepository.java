package io.github.gilbertowm.projetos.model.repository;

import io.github.gilbertowm.projetos.model.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto,Integer> {
}
