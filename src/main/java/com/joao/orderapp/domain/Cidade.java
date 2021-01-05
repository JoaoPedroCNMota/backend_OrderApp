package com.joao.orderapp.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cidade implements Serializable {

    @Id @GeneratedValue
    private Integer id;
    @Getter @Setter private String nome;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    @Getter @Setter private Estado estado;

}
