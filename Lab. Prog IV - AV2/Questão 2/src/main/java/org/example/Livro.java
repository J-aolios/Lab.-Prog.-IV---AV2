package org.example;

class Livro extends Material {
    private final String autor;
    private final String isbn;

    public Livro(String titulo, String codigo, int quantidade, String autor, String isbn) {
        super(titulo, codigo, quantidade);
        this.autor = autor;
        this.isbn = isbn;
    }

    @Override
    public int getPrazoDevolucaoDias() {
        return 14;
    }

    @Override
    public String toString() {
        return "Livro    " + super.toString() + " | Autor: " + autor + " | ISBN: " + isbn;
    }
}