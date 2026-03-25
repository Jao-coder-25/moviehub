package com.moviehub.main;

import com.moviehub.service.BuscadorDeFilme;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        BuscadorDeFilme buscador = new BuscadorDeFilme();
        String resultado = buscador.buscarFilme("matrix");
        System.out.println(resultado);
    }
}
