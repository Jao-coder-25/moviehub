package com.moviehub.main;

import com.moviehub.model.Filme;
import com.moviehub.service.BuscadorDeFilme;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do filme para busca: ");
        var nomeDoFilme = scanner.nextLine();
        BuscadorDeFilme buscador = new BuscadorDeFilme();
        Filme filme = buscador.buscarFilme(nomeDoFilme);
        if (filme != null){
            System.out.println(filme);
        }else {
            System.out.println("Filme não encontrado. Possíveis causas abaixo \n Três opções: \n 1°- Título digitado não está em inglês \n ou \n 2°- Filme inexistente \n ou \n 3°- Filme indisponível na plataforma!");
    }
        scanner.close();
    }
}
