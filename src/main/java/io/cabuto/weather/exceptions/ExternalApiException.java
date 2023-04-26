package io.cabuto.weather.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ExternalApiException {
    public ExternalApiException(String message) {
        super(message);
    }
}

// Essa exception pode ser lançada caso ocorra algum erro ao tentar consumir a API externa do OpenWeatherMap.