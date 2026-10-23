package org.example;

class ProdutoNaoPerecivel extends Produto {
    public ProdutoNaoPerecivel(String nome, double preco, int quantidade) {
        super(nome, preco, quantidade);
    }

    @Override
    public String toString() {
        return super.toString() + " (não perecível)";
    }
}
