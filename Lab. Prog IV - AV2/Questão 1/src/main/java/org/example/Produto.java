package org.example;

abstract class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        if (preco < 0 || quantidade < 0) {
            throw new IllegalArgumentException("Preço e quantidade não podem ser negativos.");
        }
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    public boolean temEstoqueBaixo() {
        return quantidade < 7;
    }

    public void vender(int qtd) throws ProdutoSemEstoqueException, EstoqueInsuficienteException {
        if (quantidade == 0) {
            throw new ProdutoSemEstoqueException();
        }
        if (qtd > quantidade) {
            throw new EstoqueInsuficienteException(nome, quantidade, qtd);
        }
        quantidade -= qtd; // atualização automática do estoque
    }

    @Override
    public String toString() {
        return String.format("%s | R$ %.2f | Qtd: %d", nome, preco, quantidade);
    }
}
