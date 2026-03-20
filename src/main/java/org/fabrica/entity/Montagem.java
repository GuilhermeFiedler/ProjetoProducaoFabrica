package org.fabrica.entity;

import org.fabrica.exception.ProdutoInvalidoException;
import org.fabrica.repository.ProdutoEstocar;

public class Montagem implements Maquina {

    private ProdutoEstocar estoque = new ProdutoEstocar();

    @Override
    public void processar(Produto produto) throws ProdutoInvalidoException {

        if (produto == null) {
            throw new ProdutoInvalidoException("Produto inválido");
        }
        if (produto.getCor() == null) {
            throw new ProdutoInvalidoException("Produto deve ser pintado antes de montado");
        }

        System.out.println("Montando produto: " + produto.getNome());

        estoque.salvar(produto);
    }

}
