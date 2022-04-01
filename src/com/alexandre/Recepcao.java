package com.alexandre;

import java.util.*;

public class Recepcao {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Integer, Livro> livros = new HashMap<>();
        Map<Integer, Leitor> leitores = new HashMap<>();
        List<Emprestimo> listaEmprestimo = new ArrayList<>();

        System.out.print("Bem vindo!\nDigite a opção desejada: " +
                "\n1 - Adicionar Livro" +
                "\n2 - Adicionar Usuário" +
                "\n3 - Consultar Biblioteca de Livros" +
                "\n4 - Consultar Situação de Livro" +
                "\n5 - Registrar Empréstimo" +
                "\n6 - Registrar Devolução" +
                "\n7 - Consultar Multa" +
                "\n8 - Exibir Lista de Emprestados" +
                "\n0 - Sair\n");

        Livro.exibirBiblioteca(livros);

        int opcao = 1;
        System.out.print("Opção: ");
        opcao = scan.nextInt();

        livros.put(01, new Livro("alexandre", "pessoa"));
        livros.put(03, new Livro("alexandre", "teste1"));
        livros.put(04, new Livro("alexandre", "teste2"));
        livros.put(02, new Livro("aline", "dentista"));

        leitores.put(01, new Leitor("Alexandre"));
        leitores.put(02, new Leitor("Aline"));
        leitores.put(03, new Leitor("Rocha"));
        leitores.put(04, new Leitor("Gislaine"));

        while (opcao > 0 && opcao <= 8) {
//                opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    Livro.adicionarLivro(livros);
                    break;
                case 2:
                    Leitor.adicionarLeitor(leitores);
                    break;
                case 3:
                    Livro.exibirBiblioteca(livros);
                    break;
                case 4:
                    Livro.consultarSituacao(livros);
                    break;
                case 5:
                    Emprestimo.retirada(livros, leitores, listaEmprestimo);
                    break;
                case 6:
                case 7:
                case 8:
                    Emprestimo.exibirListaEmprestimo(listaEmprestimo);
                    break;
            }
            System.out.print("Opção: ");
            opcao = scan.nextInt();
            if (opcao != 0 && opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5 && opcao != 6 && opcao != 7 && opcao != 8) {
                System.out.print("Opção Inválida!\nDigite novamente: ");
                opcao = scan.nextInt();
            }
        }
    }
}

