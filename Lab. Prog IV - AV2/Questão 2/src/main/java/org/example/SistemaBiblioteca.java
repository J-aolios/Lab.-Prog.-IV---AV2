package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SistemaBiblioteca {
    private final List<Material> acervo = new ArrayList<>();

    public void cadastrar(Material m) {
        acervo.add(m);
    }

    public void listarAcervo() {
        System.out.println("\n--- Acervo ---");
        for (Material m : acervo) {
            System.out.println(m);
        }
    }

    // Regras 4 e 7
    public Emprestimo finalizarEmprestimo(Usuario u) throws BibliotecaException {
        Carrinho carrinho = u.getCarrinho();

        if (carrinho.estaVazio()) {
            throw new BibliotecaException("Não é possível finalizar com o carrinho vazio");
        }

        // Valida quantidade disponível de cada material
        Map<Material, Integer> contagem = new HashMap<>();
        for (Material m : carrinho.getItens()) {
            contagem.merge(m, 1, Integer::sum);
        }
        for (Map.Entry<Material, Integer> e : contagem.entrySet()) {
            if (e.getValue() > e.getKey().getQuantidadeDisponivel()) {
                throw new BibliotecaException("Quantidade insuficiente de \""
                        + e.getKey().getTitulo() + "\"");
            }
        }

        // Atualiza o estoque automaticamente
        List<Material> materiais = carrinho.getItens();
        for (Material m : materiais) {
            m.retirarUnidade();
        }

        Emprestimo emprestimo = new Emprestimo(u, materiais, LocalDate.now());
        carrinho.limpar();
        return emprestimo;
    }

    // Regra 6: devolução atualiza a quantidade disponível
    public void devolver(Emprestimo emprestimo, Material material) throws BibliotecaException {
        for (ItemEmprestimo item : emprestimo.getItens()) {
            if (item.getMaterial() == material && !item.isDevolvido()) {
                item.marcarDevolvido();
                material.devolverUnidade();
                System.out.println("Devolvido: " + material.getTitulo());
                return;
            }
        }
        throw new BibliotecaException("Este material não consta como pendente neste empréstimo");
    }
}
