package org.example;

import java.util.ArrayList;
import java.util.List;

class Carrinho {
    public static final int LIMITE_ITENS = 5;
    private final List<Material> itens = new ArrayList<>();

    public void adicionar(Material m) throws BibliotecaException {
        int jaNoCarrinho = contar(m);
        // Regra 2: só entra se houver unidades disponíveis
        if (m.getQuantidadeDisponivel() - jaNoCarrinho <= 0) {
            throw new BibliotecaException("Material indisponível");
        }
        // Regra 3: máximo de 5 unidades por operação
        if (itens.size() >= LIMITE_ITENS) {
            throw new BibliotecaException("Limite de " + LIMITE_ITENS + " materiais por empréstimo atingido");
        }
        itens.add(m);
    }

    public void remover(Material m) throws BibliotecaException {
        if (!itens.remove(m)) {
            throw new BibliotecaException("O material não está no carrinho");
        }
    }

    public int contar(Material m) {
        int c = 0;
        for (Material i : itens) {
            if (i == m) c++;
        }
        return c;
    }

    public List<Material> getItens() {
        return new ArrayList<>(itens);
    }

    public boolean estaVazio() {
        return itens.isEmpty();
    }

    public void limpar() {
        itens.clear();
    }

    public void exibir() {
        if (itens.isEmpty()) {
            System.out.println("  (carrinho vazio)");
            return;
        }
        for (Material m : itens) {
            System.out.println("  - " + m.getTitulo());
        }
    }
}