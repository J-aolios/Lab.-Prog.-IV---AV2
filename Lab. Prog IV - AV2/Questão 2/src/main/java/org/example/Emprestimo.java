package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Emprestimo {
    private final Usuario usuario;
    private final List<ItemEmprestimo> itens = new ArrayList<>();

    public Emprestimo(Usuario usuario, List<Material> materiais, LocalDate data) {
        this.usuario = usuario;
        for (Material m : materiais) {
            itens.add(new ItemEmprestimo(m, data));
        }
    }

    public Usuario getUsuario() { return usuario; }
    public List<ItemEmprestimo> getItens() { return itens; }

    public void exibir() {
        System.out.println("Empréstimo de " + usuario.getNome() + ":");
        for (ItemEmprestimo i : itens) {
            System.out.println("  - " + i);
        }
    }
}