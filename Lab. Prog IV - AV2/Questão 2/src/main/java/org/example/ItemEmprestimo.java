package org.example;

import java.time.LocalDate;

class ItemEmprestimo {
    private final Material material;
    private final LocalDate dataEmprestimo;
    private final LocalDate dataPrevistaDevolucao;
    private boolean devolvido = false;

    public ItemEmprestimo(Material material, LocalDate dataEmprestimo) {
        this.material = material;
        this.dataEmprestimo = dataEmprestimo;
        // Regra 5: 14 dias para livros, 7 para revistas (polimorfismo)
        this.dataPrevistaDevolucao = dataEmprestimo.plusDays(material.getPrazoDevolucaoDias());
    }

    public Material getMaterial() { return material; }
    public LocalDate getDataPrevistaDevolucao() { return dataPrevistaDevolucao; }
    public boolean isDevolvido() { return devolvido; }
    void marcarDevolvido() { devolvido = true; }

    @Override
    public String toString() {
        return material.getTitulo() + " | Devolver até: " + dataPrevistaDevolucao
                + (devolvido ? " (devolvido)" : "");
    }
}