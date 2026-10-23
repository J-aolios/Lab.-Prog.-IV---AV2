package org.example;

class EstoqueInsuficienteException extends Exception {
    public EstoqueInsuficienteException(String nome, int disponivel, int solicitado) {
        super("Quantidade solicitada (" + solicitado + ") superior ao estoque disponível ("
                + disponivel + ") de " + nome);
    }
}
