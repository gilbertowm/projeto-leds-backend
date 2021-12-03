package io.github.gilbertowm.projetos.rest;

import io.github.gilbertowm.projetos.model.entity.Projeto;
import io.github.gilbertowm.projetos.model.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {

    private final ProjetoRepository repository;

    @Autowired
    public ProjetoController(ProjetoRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Projeto salvar(@RequestBody Projeto projeto ){
        return repository.save(projeto);
    }
}
