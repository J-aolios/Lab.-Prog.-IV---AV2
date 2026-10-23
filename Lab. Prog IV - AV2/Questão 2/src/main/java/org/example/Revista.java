package org.example;

class Revista extends Material {
    private final int numeroEdicao;
    private final String mesPublicacao;

    public Revista(String titulo, String codigo, int quantidade, int numeroEdicao, String mesPublicacao) {
        super(titulo, codigo, quantidade);
        this.numeroEdicao = numeroEdicao;
        this.mesPublicacao = mesPublicacao;
    }

    @Override
    public int getPrazoDevolucaoDias() {
        return 7;
    }

    @Override
    public String toString() {
        return "Revista  " + super.toString() + " | Edição: " + numeroEdicao + " | Mês: " + mesPublicacao;
    }
}
