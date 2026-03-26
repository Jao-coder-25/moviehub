package com.moviehub.model;

import com.google.gson.annotations.SerializedName;

public class Filme {

    @SerializedName("Title")
    private String titulo;

    @SerializedName("Year")
    private String ano;

    @SerializedName("Genre")
    private String genero;

    @SerializedName("Plot")
    private String sinopse;

    @SerializedName("Response")
    private String resposta;

    public String getTitulo() {
        return titulo;
    }
    public String getAno() {
        return ano;
    }
    public String getGenero() {
        return genero;
    }
    public String getSinopse() {
        return sinopse;
    }
    public String getResposta() {
        return resposta;
    }
    @Override
    public String toString() {
        return "Título: " + titulo +
                "\nAno: " + ano +
                "\nGênero: " + genero +
                "\nSinopse: " + sinopse;
    }
}
