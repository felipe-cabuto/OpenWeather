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
    private SysInfo sysInfo;

    @JsonProperty("main")
    private WeatherInfo weatherInfo;

    public static class Coordinates {
        @JsonProperty("lat")
        private double latitude;

        @JsonProperty("lon")
        private double longitude;

    }

    public static class SysInfo {
        @JsonProperty("sunrise")
        private long sunrise;

        @JsonProperty("sunset")
        private long sunset;

    }

    public static class WeatherInfo {
        @JsonProperty("temp")
        private double temperature;

        @JsonProperty("feels_like")
        private double feelsLike;

        @JsonProperty("pressure")
        private int pressure;

        @JsonProperty("humidity")
        private int humidity;

    }
}

// PARTE 4
// Essa classe é a representação dos dados retornados pela API do OpenWeatherMap, que serão mapeados em um objeto WeatherData.