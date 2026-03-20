package org.fabrica.entity;

import org.fabrica.exception.ProdutoInvalidoException;

public interface Maquina {

    void processar(Produto produto) throws ProdutoInvalidoException;

}
