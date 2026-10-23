package org.example;

import java.util.ArrayList;
import java.util.List;

class Estoque {
    private List<Produto> produtos = new ArrayList<>();

    public void cadastrar(Produto p) {
        produtos.add(p);
        verificarEstoqueBaixo(p);
    }

    public Produto buscar(String nome) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public void realizarVenda(String nome, int qtd) {
        Produto p = buscar(nome);
        if (p == null) {
            System.out.println("Produto não encontrado: " + nome);
            return;
        }
        try {
            p.vender(qtd);
            System.out.println("Venda realizada: " + qtd + "x " + p.getNome()
                    + " | Estoque atual: " + p.getQuantidade());
            verificarEstoqueBaixo(p); // Regra 1
        } catch (ProdutoSemEstoqueException | EstoqueInsuficienteException e) {
            System.out.println("Venda negada: " + e.getMessage());
        }
    }

    private void verificarEstoqueBaixo(Produto p) {
        if (p.temEstoqueBaixo()) {
            System.out.println("ALERTA: estoque baixo de \"" + p.getNome()
                    + "\" (" + p.getQuantidade() + " un.). Necessária reposição!");
        }
    }

    public void listar() {
        System.out.println("\n--- Estoque ---");
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}
