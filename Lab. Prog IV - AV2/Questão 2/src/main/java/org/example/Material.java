package org.example;

abstract class Material {
    private final String titulo;
    private final String codigo;
    private int quantidadeDisponivel;

    public Material(String titulo, String codigo, int quantidadeDisponivel) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getTitulo() { return titulo; }
    public String getCodigo() { return codigo; }
    public int getQuantidadeDisponivel() { return quantidadeDisponivel; }

    public boolean estaDisponivel() {
        return quantidadeDisponivel > 0;
    }

    // Usados somente pela biblioteca ao finalizar/devolver (encapsulamento)
    void retirarUnidade() {
        quantidadeDisponivel--;
    }

    void devolverUnidade() {
        quantidadeDisponivel++;
    }

    // Polimorfismo: cada tipo define seu prazo
    public abstract int getPrazoDevolucaoDias();

    @Override
    public String toString() {
        return String.format("[%s] %s | Disponível: %d | Prazo: %d dias",
                codigo, titulo, quantidadeDisponivel, getPrazoDevolucaoDias());
    }
}
