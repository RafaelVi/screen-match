package br.com.alura.screenmatch.models;

public record DadosSerie(@JsonAlias String titulo,
                         String avaliacao,
                         String dataDeLancamento,
                         int totalDeTemporadas) {
}
