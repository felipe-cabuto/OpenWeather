package io.cabuto.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDto {

    private double lat;
    private double lon;
    private LocalDateTime sunrise;
    private LocalDateTime sunset;
    private double temp;
    private double feelsLike;
    private double pressure;
    private int humidity;
}

// A classe WeatherDto possui os mesmos campos da classe Weather porém aqui representa um objeto de transferência de dados.

// Anotações fornecida pela biblioteca Lombok:
// @Getter - gera automaticamente o método getter para cada campo da classe. O método getter permite acessar o valor de um campo específico.
// @Setter - gera automaticamente o método setter para cada campo da classe. O método setter permite definir o valor de um campo específico.
// @AllArgsConstructor - gera automaticamente um construtor que aceita todos os campos da classe como argumentos. Isso significa que você pode criar uma instância da classe WeatherDto e inicializar seus campos ao mesmo tempo, passando valores para o construtor.
// @NoArgsConstructor - gera automaticamente um construtor sem argumentos. Isso permite criar uma instância vazia da classe WeatherDto sem fornecer valores para os campos.