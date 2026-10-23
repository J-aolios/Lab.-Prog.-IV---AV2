package org.example;

class ProdutoSemEstoqueException extends Exception {
    public ProdutoSemEstoqueException() {
        super("Produto sem estoque");
    }
}
