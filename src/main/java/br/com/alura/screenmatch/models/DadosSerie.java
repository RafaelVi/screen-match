package br.com.alura.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("imdbRating") String avaliacao,
                         @JsonAlias("Released") String dataDeLancamento,
                         @JsonAlias("totalSeasons") int totalDeTemporadas) {
}
