package org.fabrica.entity;

public class Produto {

    private int id;
    private String nome;
    private TipoProduto tipo;
    private CorProduto cor;

    public Produto(String nome, TipoProduto tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public Produto(int id, String nome, TipoProduto tipo, CorProduto cor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.cor = cor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public CorProduto getCor() {
        return cor;
    }

    public void setCor(CorProduto cor) {
        this.cor = cor;
    }
}
