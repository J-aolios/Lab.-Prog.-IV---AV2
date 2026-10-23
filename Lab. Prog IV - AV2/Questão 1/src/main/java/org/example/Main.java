package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        estoque.cadastrar(new ProdutoPerecivel("Leite", 5.50, 20, LocalDate.of(2026, 12, 1)));
        estoque.cadastrar(new ProdutoNaoPerecivel("Cadeira", 120.00, 8));
        estoque.cadastrar(new ProdutoNaoPerecivel("Mesa", 350.00, 3));


        estoque.listar();
        System.out.println();

        estoque.realizarVenda("Leite", 5);
        estoque.realizarVenda("Cadeira", 2);
        estoque.realizarVenda("Mesa", 10);
        estoque.realizarVenda("Mesa", 3);
        estoque.realizarVenda("Mesa", 1);

        estoque.listar();
    }
}