package io.cabuto.weather.services;

import io.cabuto.weather.controllers.WeatherData;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
    @Service
    public class WeatherService {

        @Value("${openweathermap.api.url}")
        private String apiUrl;

        @Value("${openweathermap.api.key}")
        private String apiKey;

        public WeatherData getWeatherData(String lat, String lon) {
            String url = String.format("%s?lat=%s&lon=%s&appid=%s&units=metric", apiUrl, lat, lon, apiKey);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<WeatherApiResponse> response = restTemplate.getForEntity(url, WeatherApiResponse.class);

            if (response.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("Failed to get weather data");
            }

            WeatherApiResponse weatherApiResponse = response.getBody();
            WeatherData weatherData = new WeatherData();
            weatherData.setLat(weatherApiResponse.getLat());
            weatherData.setLon(weatherApiResponse.getLon());
            weatherData.setSunrise(new Date(weatherApiResponse.getCurrent().getSunrise() * 1000));
            weatherData.setSunset(new Date(weatherApiResponse.getCurrent().getSunset() * 1000));
            weatherData.setTemp(weatherApiResponse.getCurrent().getTemp());
            weatherData.setFeelsLike(weatherApiResponse.getCurrent().getFeelsLike());
            weatherData.setPressure(weatherApiResponse.getCurrent().getPressure());
            weatherData.setHumidity(weatherApiResponse.getCurrent().getHumidity());

            return weatherData;
        }
    }

// A classe WeatherService é responsável por essa chamada e por transformar a resposta da API em um objeto WeatherData, que é retornado ao chamador do método.

//1) @Service - anotação que informa ao Spring que esta classe é um serviço, ou seja, que ela é responsável por executar uma determinada lógica de negócios em um contexto específico.
//2) @Value("${openweathermap.api.url}") - anotação que informa ao Spring que o valor da propriedade openweathermap.api.url definida no arquivo de configuração do Spring deve ser injetado na variável apiUrl.
//3) @Value("${openweathermap.api.key}") - anotação que informa ao Spring que o valor da propriedade openweathermap.api.key definida no arquivo de configuração do Spring deve ser injetado na variável apiKey.
//4) public WeatherData getWeatherData(String lat, String lon) - o método que realiza a chamada à API do OpenWeatherMap e retorna um objeto WeatherData com os dados meteorológicos. Ele recebe como parâmetros a latitude lat e a longitude lon.
//5) String url = String.format("%s?lat=%s&lon=%s&appid=%s&units=metric", apiUrl, lat, lon, apiKey); - constrói a URL de chamada à API do OpenWeatherMap, substituindo as variáveis %s pelos valores correspondentes das variáveis apiUrl, lat, lon e apiKey.
//6) RestTemplate restTemplate = new RestTemplate(); - instancia um objeto RestTemplate, que é uma classe do Spring que permite fazer chamadas HTTP usando uma API simples.
//7) ResponseEntity<WeatherApiResponse> response = restTemplate.getForEntity(url, WeatherApiResponse.class); - realiza uma chamada GET à URL da API construída anteriormente usando o RestTemplate, e armazena a resposta em uma variável ResponseEntity<WeatherApiResponse>. A classe WeatherApiResponse é a representação dos dados retornados pela API do OpenWeatherMap, que serão mapeados em um objeto WeatherData.
//8) if (response.getStatusCode() != HttpStatus.OK) { throw new RuntimeException("Failed to get weather data"); } - verifica se a resposta HTTP da API do OpenWeatherMap foi bem sucedida (código de status 200 OK), caso contrário, lança uma exceção.
//9) WeatherApiResponse weatherApiResponse = response.getBody(); - obtém o corpo da resposta da API do OpenWeatherMap, que é um objeto WeatherApiResponse.
//10) WeatherData weatherData = new WeatherData(); - instancia um objeto WeatherData, que será preenchido com os dados obtidos da API do OpenWeatherMap.
//11) weatherData.setLat(weatherApiResponse.getLat()); - preenche a latitude do objeto WeatherData com o valor obtido da API do OpenWeatherMap.
//12) weatherData.setLon(weatherApiResponse.getLon()); - preenche a longitude do objeto WeatherData com o valor obtido da API do OpenWeatherMap.
//13) weatherData.setSunrise(new Date(weatherApiResponse.getCurrent().getSunrise() * 1000)); - preenche
