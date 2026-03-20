package org.fabrica;


import org.fabrica.entity.Produto;
import org.fabrica.exception.ProdutoInvalidoException;
import org.fabrica.repository.ProdutoEstocar;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.init();

        Produto carro = new Produto("Sedan", TipoProduto.CARRO);
        Produto moto = new Produto("Esportiva", TipoProduto.MOTO);

        Maquina maquina = new Montagem();

        try {

            maquina.processar(carro);
            maquina.processar(moto);

        } catch (ProdutoInvalidoException e) {
            System.out.println(e.getMessage());
        }

        ProdutoEstocar repository = new ProdutoEstocar();

        List<Produto> produtos = repository.listarTodos();

        System.out.println("\nProdutos produzidos:");

        for (Produto p : produtos) {
            System.out.println(p.getId() + " - " + p.getNome() + " - " + p.getTipo());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pressione ENTER para fechar...");
        scanner.nextLine();
    }

}