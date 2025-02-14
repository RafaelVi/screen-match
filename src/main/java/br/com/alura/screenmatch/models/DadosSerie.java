package br.com.alura.screenmatch.models;


import org.codehaus.jackson.annotate.JsonProperty;

public record DadosSerie(@JsonProperty String titulo,
                         @JsonProperty String avaliacao,
                         @JsonProperty String dataDeLancamento,
                         @JsonProperty int totalDeTemporadas) {
}
