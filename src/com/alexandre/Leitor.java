package com.alexandre;

import java.util.Map;
import java.util.Scanner;

public class Leitor {

    String nome;
    static int REGISTRO = 1;

    public Leitor(String nome) {
        this.nome = nome;
        this.REGISTRO++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void adicionarLeitor(Map<Integer, Leitor> leitores) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nome do Leitor: ");
        String nome = scan.nextLine();

        leitores.put(REGISTRO, new Leitor(nome));
    }

    public static void listaEmprestimos() {

    }

}
