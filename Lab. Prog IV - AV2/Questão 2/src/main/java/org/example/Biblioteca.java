package org.example;

public class Biblioteca {
    public static void main(String[] args) {
        SistemaBiblioteca bib = new SistemaBiblioteca();

        Livro l1 = new Livro("Dom Casmurro", "L001", 2, "Machado de Assis", "978-85-359-0277-5");
        Livro l2 = new Livro("Vidas Secas", "L002", 1, "Graciliano Ramos", "978-85-01-01234-5");
        Revista r1 = new Revista("Superinteressante", "R001", 3, 450, "Setembro");

        bib.cadastrar(l1);
        bib.cadastrar(l2);
        bib.cadastrar(r1);
        // new Material(...) -> erro de compilação (classe abstrata)

        bib.listarAcervo();

        Usuario maria = new Usuario("Maria");
        Carrinho c = maria.getCarrinho();

        try {
            System.out.println("\n>> Adicionando itens ao carrinho");
            c.adicionar(l1);
            c.adicionar(l2);
            c.adicionar(r1);
            c.adicionar(l2); // l2 só tem 1 unidade -> indisponível
        } catch (BibliotecaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            System.out.println("\n>> Removendo revista do carrinho e readicionando");
            c.remover(r1);
            c.adicionar(r1);
            System.out.println("Carrinho:");
            c.exibir();

            System.out.println("\n>> Testando limite de 5 itens");
            c.adicionar(r1);
            c.adicionar(r1);
            c.adicionar(l1); // 6º item -> limite excedido
        } catch (BibliotecaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        Emprestimo emprestimo = null;
        try {
            System.out.println("\n>> Finalizando empréstimo");
            emprestimo = bib.finalizarEmprestimo(maria);
            emprestimo.exibir();
        } catch (BibliotecaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        bib.listarAcervo();

        try {
            System.out.println("\n>> Finalizando com carrinho vazio");
            bib.finalizarEmprestimo(maria);
        } catch (BibliotecaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            System.out.println("\n>> Devolvendo materiais");
            bib.devolver(emprestimo, l1);
            bib.devolver(emprestimo, r1);
            bib.devolver(emprestimo, l1); // já devolvido -> erro
        } catch (BibliotecaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        bib.listarAcervo();
    }
}