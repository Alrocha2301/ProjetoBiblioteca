package com.alexandre;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Emprestimo {

    String leitor;
    String livro;
    Integer codigo;
    LocalDate dataRetirada;
    LocalDate dataDevolucaoPrevista;


    public Emprestimo(String leitor, String livro, Integer codigo, LocalDate dataRetirada, LocalDate dataDevolucaoPrevista) {
        this.leitor = leitor;
        this.livro = livro;
        this.codigo = codigo;
        this.dataRetirada = dataRetirada;
        this.dataDevolucaoPrevista = dataRetirada.plusDays(14l);
    }

    public static void retirada(Map<Integer, Livro> livros, Map<Integer, Leitor> leitores, List<Emprestimo> listaEmprestimo) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o código do usuário: ");
        int codigo = Integer.parseInt(scan.nextLine());
        int count = 0;
        int count2 = 0;
        String nomeLivro = "";
        String situacaoLivro = "";
        String usuario = "";
        out:
        for (Map.Entry<Integer, Leitor> leitor : leitores.entrySet()) {
            if (codigo == leitor.getKey()) {
                System.out.println("Usuário: " + leitor.getValue().nome);
                usuario = leitor.getValue().nome;
                count++;
                System.out.print("Digite o nome do livro que deseja pegar: ");
                String livroEmprestado = scan.nextLine();
                for (Map.Entry<Integer, Livro> livro : livros.entrySet()) {
                    nomeLivro = livro.getValue().getNome();
                    situacaoLivro = livro.getValue().situacao;
                    if (livroEmprestado.equals(livro.getValue().nome) && livro.getValue().situacao.equals("Disponível")) {
                        //trocar situação de livro
                        Livro a = livro.getValue();
                        a.setSituacao("Indisponível");
                        livros.put(livro.getKey(), a);
                        System.out.print("Data da retirada: ");
                        String data = scan.nextLine();
                        LocalDate dataRetirada = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        LocalDate dataDevolucaoPrevista = dataRetirada.plusDays(14L);
                        System.out.println("Data da Devolução: " + dataDevolucaoPrevista.getDayOfMonth() + "/"
                                + dataDevolucaoPrevista.getMonthValue() +
                                "/" + dataDevolucaoPrevista.getYear());

                        preencherListaEmprestimo(listaEmprestimo, usuario, nomeLivro, codigo, dataRetirada, dataDevolucaoPrevista);
                        count2++;
                        break out;
                    }
                    if (livroEmprestado.equals(nomeLivro) && situacaoLivro.equals("Indisponível")) {
                        System.out.println("Livro Indisponível!");
                        break out;
                    }
                }
                if (count2 == 0) {
                    System.out.println("Livro não encontrado.");
                    break out;
                }
            }
        }
        if (count == 0) System.out.println("Usuário não encontrado.");
    }


    public static void preencherListaEmprestimo(List<Emprestimo> listaEmprestimo, String usuario, String nomeLivro, Integer codigo, LocalDate dataRetirada, LocalDate dataDevolucaoPrevista) {
        listaEmprestimo.add(new Emprestimo(usuario, nomeLivro, codigo, dataRetirada, dataDevolucaoPrevista));
    }

    public static void exibirListaEmprestimo(List<Emprestimo> listaEmprestimo) {
        for (int i = 0; i < listaEmprestimo.size(); i++) {
            System.out.println("Usuário: " + listaEmprestimo.get(i).leitor +
                    " - Livro: " + listaEmprestimo.get(i).livro +
                    " - Código: " + listaEmprestimo.get(i).codigo +
                    " - Data de Retirada: " + listaEmprestimo.get(i).dataRetirada +
                    " - Data Prevista de Devolução: " + listaEmprestimo.get(i).dataDevolucaoPrevista + "\n");
        }
    }
}









