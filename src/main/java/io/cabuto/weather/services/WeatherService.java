package io.cabuto.weather.services;

import io.cabuto.weather.controllers.WeatherApiResponse;
import io.cabuto.weather.controllers.WeatherData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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
