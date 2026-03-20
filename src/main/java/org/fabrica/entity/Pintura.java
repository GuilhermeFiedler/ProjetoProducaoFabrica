package org.fabrica.entity;

import org.fabrica.exception.ProdutoInvalidoException;

public class Pintura implements Maquina {
    private final CorProduto cor;

    public Pintura(CorProduto cor) {
        this.cor = cor;
    }

    @Override
    public void processar(Produto produto) throws ProdutoInvalidoException {

        if(produto == null){
            throw new ProdutoInvalidoException("Produto inválido para pintura.");
        }
        produto.setCor(cor);
        System.out.println("Pintando produto: " + produto.getNome() + " na cor " + cor);
    }

}
