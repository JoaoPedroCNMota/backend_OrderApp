package com.joao.orderapp.services;

import com.joao.orderapp.domain.Categoria;
import com.joao.orderapp.exceptions.ObjectNotFoundException;
import com.joao.orderapp.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository rep;

    public Categoria buscar(Integer id){
        Categoria cat = rep.findById(id).orElse(null);

        if(cat == null){
            throw new ObjectNotFoundException(
                    "Objeto não encontrado!, Id:" + id + " => Tipo: " + Categoria.class.getName()
            );
        }
        return cat;
    }

}
