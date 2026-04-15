package com.moviehub.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moviehub.model.Filme;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class BuscadorDeFilme {
    // Faz requisição à API OMDb e retorna um objeto Filme
    public Filme buscarFilme(String nomeFilme) throws InterruptedException, IOException {
        String apiKey = System.getenv("OMDB_API_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            throw new RuntimeException("API KEY não encontrada");
        }

        String tituloFormatado = URLEncoder.encode(nomeFilme, StandardCharsets.UTF_8);

        String endereco = "http://www.omdbapi.com/?t="
                + tituloFormatado
                + "&apikey=" + apiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client.
                send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Filme filme = gson.fromJson(json, Filme.class);

        // Verifica se a API retornou erro
        if ("False".equalsIgnoreCase(filme.getResposta())) {
            return null;
        }
        return filme;
    }
}


