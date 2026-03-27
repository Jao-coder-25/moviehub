package com.moviehub.main;

import com.moviehub.model.Filme;
import com.moviehub.service.BuscadorDeFilme;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String escolherOpcao;
        ArrayList<Filme> filmesFavoritos = new ArrayList<>();
        String nomeDoFilme;
        BuscadorDeFilme buscador = new BuscadorDeFilme();

        while (true) {
            System.out.println("Escolha uma opção: \n" +
                    "1 - Buscar filme \n" +
                    "2 - Ver seus filmes favoritos\n" +
                    "3 - Sair");
            escolherOpcao = scanner.nextLine();
            if (escolherOpcao.equals("1")) {
                System.out.println("Digite o nome do filme para busca: ");
                nomeDoFilme = scanner.nextLine();
                Filme filme = buscador.buscarFilme(nomeDoFilme);
                if (filme != null) {
                    System.out.println("\n🎬 Resultado da busca:\n");
                    System.out.println(filme);
                    System.out.println("Deseja adicionar aos favoritos? S/N");
                    String resposta = scanner.nextLine();
                    if (resposta.equalsIgnoreCase("S")) {

                        boolean adicionadoNaLista = false;

                        for (Filme f : filmesFavoritos ) {
                            if (f.getTitulo().equalsIgnoreCase(filme.getTitulo())) {
                                adicionadoNaLista = true;
                                break;
                            }
                        }if (!adicionadoNaLista) {
                                filmesFavoritos.add(filme);
                                System.out.println("Filme adicionado aos favoritos!");
                        }else {
                                System.out.println("Filme já está na lista!");
                        }
                    }
                }else {
                    System.out.println("Filme não encontrado");
                }
            } else if (escolherOpcao.equals("2")) {
            if (filmesFavoritos.isEmpty()) {
                System.out.println("Sua lista está vazia!");
            } else {
                System.out.println("🎬Seus filmes favoritos:\n");
                for (Filme f : filmesFavoritos) {
                    System.out.println(f);
                    System.out.println("--------------");
                    }
                }
            } else if (escolherOpcao.equals("3")) {
                System.out.println("Finalizando o programa");
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
       scanner.close();
    }
}
