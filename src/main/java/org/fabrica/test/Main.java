package org.fabrica.test;


import org.fabrica.config.DatabaseInitializer;
import org.fabrica.entity.*;
import org.fabrica.exception.ProdutoInvalidoException;
import org.fabrica.repository.ProdutoEstocar;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.init();

        Produto carro = new Produto("Palio", TipoProduto.CARRO);
        Produto moto = new Produto("Yamaha", TipoProduto.MOTO);
        Produto van = new Produto("Mini Van", TipoProduto.VAN);
        Produto jetski = new Produto("Jetski", TipoProduto.JETSKI);

        Maquina maquina = new Montagem();
        Maquina pinturaVermelha = new Pintura(CorProduto.VERMELHO);
        Maquina pinturaPrata = new Pintura(CorProduto.PRATA);
        try {
            System.out.println("\n=== Iniciando Pintura ===");
            pinturaVermelha.processar(carro);
            pinturaPrata.processar(moto);
            pinturaPrata.processar(van);
            pinturaPrata.processar(jetski);

            System.out.println("\n=== Iniciando Montagem ===");
            maquina.processar(carro);
            maquina.processar(moto);
            maquina.processar(van);
            maquina.processar(jetski);

        } catch (ProdutoInvalidoException e) {
            System.out.println(e.getMessage());
        }

        ProdutoEstocar repository = new ProdutoEstocar();

        List<Produto> produtos = repository.listarTodos();

        System.out.println("\n=== Produtos produzidos ===");

        for (Produto p : produtos) {
            System.out.println(p.getId() + " - " + p.getNome() + " - " + p.getTipo() + " - " + p.getCor());
        }

    }

}