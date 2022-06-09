package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    @JsonProperty(value = "WeatherText")
    private String weatherText;

    @JsonProperty(value = "Date")
    private String date;

    @JsonProperty(value = "Temperature")
    private Temperature temperature;

    @JsonProperty(value = "Day")
    private WeatherText day;

    @JsonProperty(value = "Night")
    private WeatherText night;
}
