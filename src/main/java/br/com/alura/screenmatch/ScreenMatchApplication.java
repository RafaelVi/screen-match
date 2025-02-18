package br.com.alura.screenmatch;

import br.com.alura.screenmatch.models.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenMatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var consumoApi = new ConsumoApi();
        var json = consumoApi.obterDados("http://www.omdbapi.com/?apikey=e943e54&t=Gilmore+girls&y=2000");
        System.out.println(json);
        ConverteDados converteDados = new ConverteDados();
        DadosSerie dadosSerie = converteDados.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);
    }
}
