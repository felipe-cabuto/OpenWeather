package io.cabuto.weather.controllers;

import io.cabuto.weather.entities.WeatherData;
import io.cabuto.weather.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clima")
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity<WeatherData> getWeatherData(@RequestParam("lat") String lat,
                                                      @RequestParam("long") String lon) {
        WeatherData weatherData = weatherService.getWeatherData(lat, lon);
        return ResponseEntity.ok(weatherData);
    }
}

// A classe WeatherController é responsável por lidar com as requisições na API.
// Definir o endpoint que receberá os parâmetros de latitude e longitude e que será responsável por consumir a API externa e retornar os dados do clima em um objeto.
// Esta classe irá gerenciar as requisições HTTP na rota /clima.

//1) @RestController - anotação que informa ao Spring que esta classe é um controlador REST, ou seja, que é responsável por expor endpoints HTTP que retornam dados em formato JSON.
//2) @RequestMapping("/clima") - anotação que define o caminho base para todas as rotas definidas nesta classe. Neste caso, todas as rotas gerenciadas por este controlador terão como prefixo /clima.
//3) private final WeatherService weatherService; - declaração da dependência WeatherService que será injetada pelo Spring usando a anotação @Autowired no construtor.
//4) @Autowired - anotação que informa ao Spring que ele deve injetar uma instância de WeatherService no construtor do controlador.
//5) public WeatherController(WeatherService weatherService) { ... } - o construtor da classe, que recebe uma instância de WeatherService e armazena em uma variável de instância para ser usada posteriormente.
//6) @GetMapping - uma anotação que indica que este método responde a requisições HTTP do tipo GET.
//7) public ResponseEntity<WeatherData> getWeatherData(@RequestParam("lat") String lat, @RequestParam("long") String lon) - o método que será chamado quando um cliente fizer uma requisição HTTP GET para a rota /clima. Ele recebe dois parâmetros lat e lon, que são extraídos da URL da requisição usando a anotação @RequestParam.
//8) WeatherData weatherData = weatherService.getWeatherData(lat, lon); - chamada ao método getWeatherData do serviço WeatherService, passando os parâmetros lat e lon recebidos na requisição.
//9) return ResponseEntity.ok(weatherData); - retorna uma resposta HTTP com o status 200 OK e o objeto WeatherData retornado pelo serviço WeatherService no corpo da resposta. A classe ResponseEntity é usada para permitir que o controlador especifique o status HTTP, cabeçalhos e corpo da resposta de forma mais flexível.