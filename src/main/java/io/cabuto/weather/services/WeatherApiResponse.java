package io.cabuto.weather.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherApiResponse {
    @JsonProperty("coord")
    private Coordinates coordinates;

    @JsonProperty("sys")
    private Sys sys;

    @JsonProperty("main")
    private WeatherInfo weatherInfo;
}

// PARTE 4
// Essa classe é a representação dos dados retornados pela API do OpenWeatherMap, que serão mapeados em um objeto WeatherData.