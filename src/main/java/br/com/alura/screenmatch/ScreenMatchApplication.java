package br.com.alura.screenmatch;

import br.com.alura.screenmatch.models.DadosEpisodio;
import br.com.alura.screenmatch.models.DadosSerie;
import br.com.alura.screenmatch.models.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

    private static final String BASE_URL = "http://www.omdbapi.com/?apikey=e943e54&t=";

    public static void main(String[] args) {
        SpringApplication.run(ScreenMatchApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String serie = Menu.exibeMenu("série");

        var consumoApi = new ConsumoApi();

        var json = consumoApi.obterDados(BASE_URL + serie);
        System.out.println(json);
        ConverteDados converteDados = new ConverteDados();
        DadosSerie dadosSerie = converteDados.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

        String episodio = Menu.exibeMenu("episodio");
        String jsonEpisodio = consumoApi.obterDados(BASE_URL + dadosSerie.titulo() + "&episode=" + episodio);
        DadosEpisodio dadosEpisodio = converteDados.obterDados(jsonEpisodio, DadosEpisodio.class);
        System.out.println(dadosEpisodio);

        List<DadosTemporada> listaDeTemporadas = new ArrayList<DadosTemporada>();
        for (int i = 1; i <= dadosSerie.totalDeTemporadas(); i++) {
            var jsonTemporadas = consumoApi.obterDados(BASE_URL + dadosSerie.titulo() + "&Season=" + i);
            DadosTemporada dadosTemporadas = converteDados.obterDados(jsonTemporadas, DadosTemporada.class);
            listaDeTemporadas.add(dadosTemporadas);
        }
        listaDeTemporadas.forEach(System.out::println);
    }
}
