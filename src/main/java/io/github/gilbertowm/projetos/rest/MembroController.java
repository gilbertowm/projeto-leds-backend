package io.github.gilbertowm.projetos.rest;

import io.github.gilbertowm.projetos.model.entity.Membro;
import io.github.gilbertowm.projetos.model.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/membros")
@CrossOrigin("http://localhost:4200")
public class MembroController {

    private final MembroRepository repository;

    @Autowired
    public MembroController(MembroRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Membro salvar(@RequestBody @Valid Membro membro ){
        return repository.save(membro);
    }

    @GetMapping
    public List<Membro> obterTodos(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Membro acharPorId(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Membro não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository
                .findById(id)
                .map(membro -> {
                    repository.delete(membro);
                    return Void.TYPE;
                })
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Membro não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid Membro membroAtualizado){
        repository
                .findById(id)
                .map(membro -> {
                    membro.setNome(membroAtualizado.getNome());
                    membro.setCpf(membroAtualizado.getCpf());
                    membro.setEmail(membroAtualizado.getEmail());
                    return repository.save(membro);
                })
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Membro não encontrado"));

    }

}
