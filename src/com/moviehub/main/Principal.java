package com.moviehub.main;

import com.moviehub.model.Filme;
import com.moviehub.service.BuscadorDeFilme;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String escolherOpcao;

        // Armazena os títulos originais dos filmes favoritos
        Set<String> filmesFavoritos = new HashSet<>();

        // Controla duplicidade (normalizado: sem espaços e case-insensitive)
        Set<String> titulosNormalizados = new HashSet<>();

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

                        String tituloOriginal = filme.getTitulo();

                        // Normaliza o título para evitar duplicatas com diferenças de maiúsculas/minúsculas
                        String tituloNormalizado = tituloOriginal.trim().toLowerCase();

                        // Se não existir, adiciona nos favoritos
                        if (titulosNormalizados.add(tituloNormalizado)) {
                            filmesFavoritos.add(tituloOriginal);
                            System.out.println("Filme adicionado aos favoritos com sucesso!");
                        }else {
                            System.out.println("Filme já existe na lista!");
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
                for (String f : filmesFavoritos) {
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
