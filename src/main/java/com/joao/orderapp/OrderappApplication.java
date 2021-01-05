package com.joao.orderapp;

import com.joao.orderapp.domain.Categoria;
import com.joao.orderapp.domain.Cidade;
import com.joao.orderapp.domain.Estado;
import com.joao.orderapp.domain.Produto;
import com.joao.orderapp.repositories.CategoriaRepository;
import com.joao.orderapp.repositories.CidadeRepository;
import com.joao.orderapp.repositories.EstadoRepository;
import com.joao.orderapp.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class OrderappApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrderappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat = new Categoria(null, "Informática");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Cabo HDMI", 15.99);

        p1.setCategorias(Arrays.asList(cat));
        p2.setCategorias(Arrays.asList(cat));
        p3.setCategorias(Arrays.asList(cat));

        cat.setProdutos(Arrays.asList(p1, p2, p3));

        categoriaRepository.save(cat);
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        // -------------------------------------------------
        // -------------------------------------------------

        Estado df = new Estado(null, "Distrito Federal");
        Estado mg = new Estado(null, "Minas Gerais");

        Cidade brasilia = new Cidade(null, "Brasília", df);
        Cidade bh = new Cidade(null, "Belo Horizonte", mg);
        Cidade patos = new Cidade(null, "Patos de Minas", mg);

        df.setCidades(Arrays.asList(brasilia));
        mg.setCidades(Arrays.asList(bh, patos));

        estadoRepository.saveAll(Arrays.asList(df, mg));
        cidadeRepository.saveAll(Arrays.asList(brasilia, bh, patos));
    }
}
