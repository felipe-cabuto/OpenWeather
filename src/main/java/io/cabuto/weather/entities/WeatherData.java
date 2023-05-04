package io.cabuto.weather.entities;

import lombok.Data;
import java.time.LocalDateTime;
@Data
public class WeatherData {
    private double lat;
    private double lon;
    private LocalDateTime sunrise;
    private LocalDateTime sunset;
    private double temp;
    private double feelsLike;
    private double pressure;
    private int humidity;
}

// PARTE 3
// Classe que representa dados de Clima com os seguintes atributos:

//  - latitude (lat)
//  - longitude (lon)
//  - horário do nascer do sol (sunrise)
//  - horário do pôr do sol (sunset)
//  - temperatura (temp)
//  - sensação térmica (feelsLike)
//  - pressão atmosférica em Pascal (pressure)
//  - umidade relativa do ar em percentagem (humidity).

// A anotação @Data é fornecida pela biblioteca Lombok e é usada para gerar automaticamente os métodos getters, setters, equals, hashCode e toString para os campos da classe.
// LocalDateTime é uma classe do pacote java.time que representa uma data e hora. Ela é usada para representar o nascer e o pôr do sol.