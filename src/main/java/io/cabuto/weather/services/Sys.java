package io.cabuto.weather.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class Sys {
    @JsonProperty("sunrise")
    private Instant sunrise;

    @JsonProperty("sunset")
    private Instant sunset;

}