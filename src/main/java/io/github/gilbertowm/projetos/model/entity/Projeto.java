package io.github.gilbertowm.projetos.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 150)
    private String titulo;

    @Column(nullable = false,length = 150)
    private String descricao;

    @Column(nullable = false,length = 150)
    private String tecnologia;

    @ManyToOne
    @JoinColumn(name = "id_membro")
    private Membro membro;

}
