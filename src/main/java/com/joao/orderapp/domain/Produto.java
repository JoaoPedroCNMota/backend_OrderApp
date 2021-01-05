package com.joao.orderapp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "Id")
public class Produto implements Serializable {

    @Id @GeneratedValue
    private Integer Id;
    @Getter @Setter private String nome;
    @Getter @Setter private Double preco;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn( name = "produto_id"),
            inverseJoinColumns = @JoinColumn( name = "categoria_id")
    )
    @Getter @Setter private List<Categoria> categorias = new ArrayList<>();

    public Produto(Integer id, String nome, Double preco) {
        Id = id;
        this.nome = nome;
        this.preco = preco;
    }
}
