package io.cabuto.weather.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordinates {
    @JsonProperty("lat")
    private double latitude;

    @JsonProperty("lon")
    private double longitude;

}