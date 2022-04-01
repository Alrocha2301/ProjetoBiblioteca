package com.alexandre;

import java.util.Map;
import java.util.Scanner;

public class Livro {

    String nome;
    String tema;
    static int CODIGO = 1;
    String situacao;

    public Livro(String nome, String tema) {
        this.nome = nome;
        this.tema = tema;
        this.situacao = "Disponível";
        this.CODIGO++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public static void adicionarLivro(Map<Integer, Livro> livros) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nome do Livro: ");
        String nome = scan.nextLine();
        System.out.print("Tema: ");
        String tema = scan.nextLine();


        livros.put(CODIGO, new Livro(nome, tema));
    }

    public static void exibirBiblioteca (Map<Integer, Livro> livros) {
        for (Map.Entry<Integer, Livro> livro: livros.entrySet()) {
            System.out.println("Codigo: " + livro.getKey() + " - Livro: "
                    + livro.getValue().nome + " - Tema: " + livro.getValue().tema);
        }
    }

    public static void consultarSituacao(Map<Integer, Livro> livros) {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        System.out.print("Digite o nome do livro que deseja consultar: ");
        while (count == 0) {
            String livroConsultado = scan.nextLine();
            for (Map.Entry<Integer, Livro> livro : livros.entrySet()) {
                if (livroConsultado.equals(livro.getValue().nome)) {
                    System.out.println("Livro: " + livro.getValue().nome + " - Código: " + livro.getKey() + " - Situação: " + livro.getValue().situacao);
                    count++;
                }
            }
            if (count == 0) System.out.print("Livro não Encontrado! Digite novamente: ");
        }
    }

    /*public static void exibirUmLivro(Map<Integer, Livro> livros) {
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();
        for (Map.Entry<Integer, Livro> livro : livros.entrySet()) {
            if (index == livro.getKey()){
                System.out.println("Código: " + livro.getKey() + " - Nome do Livro: "
                        + livro.getValue().nome + " Tema: " + livro.getValue().tema);
            }
        }
    }*/
}
