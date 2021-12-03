package io.github.gilbertowm.projetos.model.repository;

import io.github.gilbertowm.projetos.model.entity.Membro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroRepository extends JpaRepository<Membro,Integer> {
}
