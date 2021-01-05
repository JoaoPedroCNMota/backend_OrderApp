package com.joao.orderapp.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria implements Serializable {

    @Id @GeneratedValue
    private Integer id;
    @Getter @Setter private String nome;

    @JsonManagedReference
    @ManyToMany(mappedBy = "categorias")
    @Getter @Setter private List<Produto> produtos = new ArrayList<>();

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
