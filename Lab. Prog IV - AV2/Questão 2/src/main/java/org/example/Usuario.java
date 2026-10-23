package org.example;

class Usuario {
    private final String nome;
    private final Carrinho carrinho = new Carrinho();

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }
    public Carrinho getCarrinho() { return carrinho; }
}